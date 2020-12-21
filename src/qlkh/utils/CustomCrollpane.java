/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlkh.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
import javax.swing.ScrollPaneLayout;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author GIANG
 */
public class CustomCrollpane extends JScrollPane {

    private static final int SCROLL_BAR_ALPHA_ROLLOVER = 100;
    private static final int SCROLL_BAR_ALPHA = 60;
    private static final int THUMB_SIZE = 16; //8
    private static final int SB_SIZE = 16; //10
    private static final Color THUMB_COLOR = Color.BLACK;
    private static final Color BTN_BACKGROUND = new Color(240, 240, 240);
    private static boolean a;
    private static boolean b;

    public CustomCrollpane() {
    }

    public CustomCrollpane(Component view) {
        this(view, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }

//    public ModernScrollPane(int vsbPolicy, int hsbPolicy) {
//        this(null, vsbPolicy, hsbPolicy);
//    }
    private CustomCrollpane(Component view, int vsbPolicy, int hsbPolicy) {

        setBorder(null);

        // Set ScrollBar UI
        JScrollBar verticalScrollBar = getVerticalScrollBar();
        JScrollBar horizontalScrollBar = getHorizontalScrollBar();
        verticalScrollBar.setOpaque(true);
        verticalScrollBar.setBackground(BTN_BACKGROUND);
        verticalScrollBar.setUI(new ModernScrollBarUI(this));
        boolean horiScrollNeeded = isVerticalScrollBarfNecessary();

        boolean verticalScrollNeeded = isHorizontalScrollBarNecessary();
        if (verticalScrollNeeded == true) {

            verticalScrollBar.setOpaque(true);
            verticalScrollBar.setBackground(BTN_BACKGROUND);
        } else {

            verticalScrollBar.setOpaque(false);
        }
        horizontalScrollBar.setUI(new ModernScrollBarUI(this));

        if (horiScrollNeeded == true) {

            horizontalScrollBar.setOpaque(true);
            horizontalScrollBar.setBackground(BTN_BACKGROUND);
          //  horizontalScrollBar.set
        } else {
          
            horizontalScrollBar.setOpaque(false);
            
        }

        setLayout(new ScrollPaneLayout() {

            @Override
            public void layoutContainer(Container parent) {
                Rectangle availR = ((JScrollPane) parent).getBounds();
                availR.x = availR.y = 0;

                // viewport
                Insets insets = parent.getInsets();
                availR.x = insets.left;
                availR.y = insets.top;
                availR.width -= insets.left + insets.right;
                availR.height -= insets.top + insets.bottom;
                if (viewport != null) {
                    viewport.setBounds(availR);
                }

                boolean vsbNeeded = isVerticalScrollBarfNecessary();
                boolean hsbNeeded = isHorizontalScrollBarNecessary();

                // vertical scroll bar
                Rectangle vsbR = new Rectangle();
                vsbR.width = SB_SIZE;
                vsbR.height = availR.height - (hsbNeeded ? vsbR.width : 0);
                vsbR.x = availR.x + availR.width - vsbR.width;
                vsbR.y = availR.y;
                if (vsb != null) {
                    vsb.setBounds(vsbR);

                }

                // horizontal scroll bar
                Rectangle hsbR = new Rectangle();
                hsbR.height = SB_SIZE;
                hsbR.width = availR.width - (vsbNeeded ? hsbR.height : 0);
                hsbR.x = availR.x;
                hsbR.y = availR.y + availR.height - hsbR.height;
                if (hsb != null) {
                    hsb.setBounds(hsbR);
                }
            }
        });

        // Layering
        setComponentZOrder(getVerticalScrollBar(), 0);
        setComponentZOrder(getHorizontalScrollBar(), 1);
        setComponentZOrder(getViewport(), 2);

        viewport.setView(view);
    }

    private boolean isVerticalScrollBarfNecessary() {
        Rectangle viewRect = viewport.getViewRect();
        Dimension viewSize = viewport.getViewSize();
        return viewSize.getHeight() > viewRect.getHeight();
    }

    private boolean isHorizontalScrollBarNecessary() {
        Rectangle viewRect = viewport.getViewRect();
        Dimension viewSize = viewport.getViewSize();
        return viewSize.getWidth() > viewRect.getWidth();
    }

    /**
     * Class extending the BasicScrollBarUI and overrides all necessary methods
     */
    private static class ModernScrollBarUI extends BasicScrollBarUI {

        private final JScrollPane sp;
        private final ImageIcon downArrow, upArrow, leftArrow, rightArrow;

        public ModernScrollBarUI(CustomCrollpane sp) {
            this.sp = sp;
            upArrow = new ImageIcon(getClass().getResource("/qlkh/images/up_16.png"));

            downArrow = new ImageIcon(getClass().getResource("/qlkh/images/down_16.png"));
            rightArrow = new ImageIcon(getClass().getResource("/qlkh/images/right_16.png"));
            leftArrow = new ImageIcon(getClass().getResource("/qlkh/images/left_16.png"));
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            // return new InvisibleScrollBarButton();

            a = new CustomCrollpane().isVerticalScrollBarfNecessary();
            b = new CustomCrollpane().isHorizontalScrollBarNecessary();

            JButton decreaseButton = new JButton(getAppropriateIcon(orientation)) {
                @Override
                public Dimension getPreferredSize() {
                    if(a||b){
                          return new Dimension(22, 22);
                    }return new Dimension(0,0);
                  

                }
            };

            decreaseButton.setOpaque(true);
            decreaseButton.setBackground(BTN_BACKGROUND);

            decreaseButton.setFocusable(false);
            decreaseButton.setFocusPainted(false);
            decreaseButton.setBorderPainted(false);
            decreaseButton.setBorder(null);
            decreaseButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    decreaseButton.setBackground(Color.YELLOW);
                }

            });
            decreaseButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    decreaseButton.setBackground(BTN_BACKGROUND);
                }

            });

            return decreaseButton;
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            //    return new InvisibleScrollBarButton();
            JButton increaseButton = new JButton(getAppropriateIcon(orientation)) {
                @Override
                public Dimension getPreferredSize() {
                    if(a&&b){
                        
                          return new Dimension(22, 22);
                    }return new Dimension(0,0);
                  
                }
            };
           
          
            increaseButton.setOpaque(true);
            increaseButton.setBackground(BTN_BACKGROUND);

            increaseButton.setFocusable(false);
            increaseButton.setFocusPainted(false);
            increaseButton.setBorderPainted(false);
            increaseButton.setBorder(null);
            increaseButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    increaseButton.setBackground(Color.YELLOW);
                }

            });
            increaseButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    increaseButton.setBackground(BTN_BACKGROUND);
                }

            });
            return increaseButton;
        }

        @Override
        protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        }

        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
            int alpha = isThumbRollover() ? SCROLL_BAR_ALPHA_ROLLOVER : SCROLL_BAR_ALPHA;
            int orientation = scrollbar.getOrientation();
            int x = thumbBounds.x;
            int y = thumbBounds.y;

            int width = orientation == JScrollBar.VERTICAL ? THUMB_SIZE : thumbBounds.width;
            width = Math.max(width, THUMB_SIZE);

            int height = orientation == JScrollBar.VERTICAL ? thumbBounds.height : THUMB_SIZE;
            height = Math.max(height, THUMB_SIZE);

            Graphics2D graphics2D = (Graphics2D) g.create();
            graphics2D.setColor(new Color(THUMB_COLOR.getRed(), THUMB_COLOR.getGreen(), THUMB_COLOR.getBlue(), alpha));
            graphics2D.fillRect(x, y, width, height);
            graphics2D.dispose();
        }

        @Override
        protected void setThumbBounds(int x, int y, int width, int height) {
            super.setThumbBounds(x, y, width, height);
            sp.repaint();
        }

        private ImageIcon getAppropriateIcon(int orientation) {
            switch (orientation) {
                case SwingConstants.SOUTH:
                    return downArrow;
                case SwingConstants.NORTH:
                    return upArrow;
                case SwingConstants.EAST:
                    return rightArrow;
                default:
                    return leftArrow;
            }
        }

    }

}
