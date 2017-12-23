package cn.pallasli.layout;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class FlowLinearLayout extends LinearLayout {

    private int paddingy = 10;
    private int paddingx = 40;
    private int margin=20;

    public FlowLinearLayout(Context context) {
        this(context, null);
    }

    public FlowLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int maxWidth = MeasureSpec.getSize(widthMeasureSpec);
        int childCount = getChildCount();
        int x = margin;
        int y = 0;
        int row = 0;

        for (int index = 0; index < childCount; index++) {
            final View child = getChildAt(index);
            if (child.getVisibility() != View.GONE) {
                child.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
                int width = child.getMeasuredWidth();
                int height = child.getMeasuredHeight();
                x += width;
                if (index != 0) x += paddingx;
                y = row * height + height;
                if (x > maxWidth) {
                    x = width+margin;
                    row++;
                    y = row * height + height;
                    y += row * paddingy;
               } else if (row > 0) {
                    y = row * height + height;
                    y += row * paddingy;
                }
            }
        }
        setMeasuredDimension(maxWidth, y+margin);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        final int childCount = getChildCount();
        int maxWidth = r - l;
        int x = margin;
        int y = 0;
        int row = 0;
        for (int i = 0; i < childCount; i++) {
            final View child = this.getChildAt(i);
            if (child.getVisibility() != View.GONE) {
                int width = child.getMeasuredWidth();
                int height = child.getMeasuredHeight();
                x += width;
                if (i != 0) x += paddingx;
                y = row * height + height;
                if (x > maxWidth) {
                    x = width+margin;
                    row++;
                    y = row * height + height;
                    y += row * paddingy;
               } else if (row > 0) {
                    y = row * height + height;
                    y += row * paddingy;
                }
                child.layout(x - width, y - height+margin, x, y+margin);
            }
        }
    }

    public int getPY() {
        return paddingy;
    }

    public void setPY(int paddingy) {
        this.paddingy = paddingy;
    }

    public int getPX() {
        return paddingx;
    }

    public void setPX(int paddingx) {
        this.paddingx = paddingx;
    }
}
