package zhongkang.bawei.com.listviewcheckbox;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by zhongkang on 2016/11/2.
 */
public class KangListView extends ListView {
    public KangListView(Context context) {
        super(context);
    }

    public KangListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public KangListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
