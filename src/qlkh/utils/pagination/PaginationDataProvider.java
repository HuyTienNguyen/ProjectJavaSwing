package qlkh.utils.pagination;

import java.util.List;

public interface PaginationDataProvider<T> {
    void setList(List<T> lists );
    int getTotalRowCount(boolean isSearch);

    public String getSearchText();

    public void setSearchText(String searchText);

    List<T> getRows(int startIndex, int endIndex, boolean isSearch);

    List<T> getListsSearchByText();

}
