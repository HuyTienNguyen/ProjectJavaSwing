package qlkh.utils.pagination;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.border.LineBorder;
import javax.swing.table.TableRowSorter;

public class PaginatedTableDecorator<T> {

    private JTable table;
    private PaginationDataProvider<T> dataProvider;
    private JTextField searchField;
    private int[] pageSizes;
    private JPanel contentPanel;
    private int currentPageSize;
    private int currentPage = 1;
    private JPanel pageLinkPanel;
    private ObjectTableModel objectTableModel;
    private static int MaxPagingCompToShow = 9;
    private static final String Ellipses = "...";
    private boolean isSearch = false;

    private PaginatedTableDecorator(JTable table, PaginationDataProvider<T> dataProvider,
            int[] pageSizes, int defaultPageSize, int maxPagingCompToShow) {
        this.table = table;
        this.dataProvider = dataProvider;
        this.pageSizes = pageSizes;
        this.currentPageSize = defaultPageSize;
        this.MaxPagingCompToShow = maxPagingCompToShow;
    }

    public static <T> PaginatedTableDecorator<T> decorate(JTable table,
            PaginationDataProvider<T> dataProvider,
            int[] pageSizes, int defaultPageSize, int maxPagingCompToShow) {
        PaginatedTableDecorator<T> decorator = new PaginatedTableDecorator<>(table, dataProvider,
                pageSizes, defaultPageSize, maxPagingCompToShow);
        decorator.init();
        return decorator;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    private void init() {
        initDataModel();
        initPaginationComponents();
        initListeners();
        paginate();
    }

    private void initListeners() {
        objectTableModel.addTableModelListener(this::refreshPageButtonPanel);
      
    }

    private void initDataModel() {
        TableModel model = table.getModel();

        if (!(model instanceof ObjectTableModel)) {
            throw new IllegalArgumentException("TableModel must be a subclass of ObjectTableModel");
        }
        objectTableModel = (ObjectTableModel) model;
    }

    private void initPaginationComponents() {
        contentPanel = new JPanel(new BorderLayout());
        JPanel paginationPanel = createPaginationPanel();
        contentPanel.add(paginationPanel, BorderLayout.NORTH);
        contentPanel.add(new JScrollPane(table));
    }

    private JPanel createPaginationPanel() {
        JPanel paginationPanel = new JPanel();
        TableRowSorter<TableModel> rowSorter
                = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        JButton preBtn = new JButton("Previous");
       
        preBtn.addActionListener(action -> {
            if (currentPage > 1) {
                currentPage--;
            }
            paginate();
        });
        paginationPanel.add(preBtn);
        pageLinkPanel = new JPanel(new GridLayout(1, MaxPagingCompToShow, 3, 3));
        paginationPanel.add(pageLinkPanel);
        JButton nextBtn = new JButton("Next");
        int totalRows = dataProvider.getTotalRowCount(isIsSearch());
        int pages = (int) Math.ceil((double) totalRows / currentPageSize);
        nextBtn.addActionListener(action -> {
            if (currentPage < pages) {
                currentPage++;
            }
            paginate();
        });
        paginationPanel.add(nextBtn);

        if (pageSizes != null) {
            JComboBox<Integer> pageComboBox = new JComboBox<>(
                    Arrays.stream(pageSizes).boxed()
                    .toArray(Integer[]::new));
            pageComboBox.addActionListener((ActionEvent e) -> {
                //to preserve current rows position
                int currentPageStartRow = ((currentPage - 1) * currentPageSize) + 1;
                currentPageSize = (Integer) pageComboBox.getSelectedItem();
                currentPage = ((currentPageStartRow - 1) / currentPageSize) + 1;
                paginate();
            });
            searchField = new JTextField(10);
          
            searchField.addKeyListener(new KeyListener() {

                @Override
                public void keyTyped(KeyEvent e) {
                }

                @Override
                public void keyPressed(KeyEvent e) {
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    String text = searchField.getText().trim();
                    setIsSearch((text.length() > 0) ? true : false);
                    paginate();

                }
            });
            paginationPanel.add(Box.createHorizontalStrut(15));

            paginationPanel.add(new JLabel("Search"));
            paginationPanel.add(searchField);
            paginationPanel.add(Box.createHorizontalStrut(15));
            paginationPanel.add(new JLabel("Page Size: "));
            paginationPanel.add(pageComboBox);
            pageComboBox.setSelectedItem(currentPageSize);
        }
        return paginationPanel;
    }

    private void refreshPageButtonPanel(TableModelEvent tme) {
        pageLinkPanel.removeAll();
        int totalRows = dataProvider.getTotalRowCount(isIsSearch());
        int pages = (int) Math.ceil((double) totalRows / currentPageSize);
        ButtonGroup buttonGroup = new ButtonGroup();
        if (pages > MaxPagingCompToShow) {
            addPageButton(pageLinkPanel, buttonGroup, 1);
            if (currentPage > (pages - ((MaxPagingCompToShow + 1) / 2))) {
                //case: 1 ... n->lastPage
                pageLinkPanel.add(createEllipsesComponent());
                addPageButtonRange(pageLinkPanel, buttonGroup, pages - MaxPagingCompToShow + 3, pages);
            } else if (currentPage <= (MaxPagingCompToShow + 1) / 2) {
                //case: 1->n ...lastPage
                addPageButtonRange(pageLinkPanel, buttonGroup, 2, MaxPagingCompToShow - 2);
                pageLinkPanel.add(createEllipsesComponent());
                addPageButton(pageLinkPanel, buttonGroup, pages);
            } else {//case: 1 .. x->n .. lastPage
                pageLinkPanel.add(createEllipsesComponent());//first ellipses
                //currentPage is approx mid point among total max-4 center links
                int start = currentPage - (MaxPagingCompToShow - 4) / 2;
                int end = start + MaxPagingCompToShow - 5;
                addPageButtonRange(pageLinkPanel, buttonGroup, start, end);
                pageLinkPanel.add(createEllipsesComponent());//last ellipsis
                addPageButton(pageLinkPanel, buttonGroup, pages);//last page link
            }
        } else {
            addPageButtonRange(pageLinkPanel, buttonGroup, 1, pages);
        }
        pageLinkPanel.getParent().validate();
        pageLinkPanel.getParent().repaint();
    }

    private Component createEllipsesComponent() {
        return new JLabel(Ellipses, SwingConstants.CENTER);
    }

    private void addPageButtonRange(JPanel parentPanel, ButtonGroup buttonGroup, int start, int end) {
        for (; start <= end; start++) {
            addPageButton(parentPanel, buttonGroup, start);
        }
    }

    private void addPageButton(JPanel parentPanel, ButtonGroup buttonGroup, int pageNumber) {

        JToggleButton toggleButton = new JToggleButton(Integer.toString(pageNumber));
        toggleButton.setMargin(new Insets(1, 3, 1, 3));
        buttonGroup.add(toggleButton);
        parentPanel.add(toggleButton);
        if (pageNumber == currentPage) {
            toggleButton.setSelected(true);
        }
        toggleButton.addActionListener(ae -> {
            currentPage = Integer.parseInt(ae.getActionCommand());
            paginate();
        });
    }

    private boolean isIsSearch() {
        return isSearch;
    }

    public void setIsSearch(boolean isSearch) {
        this.isSearch = isSearch;
    }

    public String getSearchField() {
        return searchField.getText();
    }

    private void paginate() {

        int startIndex = (currentPage - 1) * currentPageSize;
        int endIndex = startIndex + currentPageSize;
        String searchField = getSearchField();
        dataProvider.setSearchText(searchField);
        int rowcounts = dataProvider.getTotalRowCount(isSearch);

        if (endIndex > rowcounts) {
            endIndex = rowcounts;
        }
       
        List<T> rows = dataProvider.getRows(startIndex, endIndex, isIsSearch());
       
        objectTableModel.setObjectRows(rows);

        objectTableModel.fireTableDataChanged();

    }
     public void addTableMouseListener(MouseListener listener) {
         table.addMouseListener(listener);
    }
}
