package zhongkang.bawei.com.listviewcheckbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Bean> listMain;
    private boolean isHide;
    private MyAdapter adapter;
    private KangListView lv;
    private String[] str=new String[]{"1111111","22222","33333"
            ,"44444","55555","66666","77777","88888","99999",
            "00000"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        lv= (KangListView) findViewById(R.id.lv);
        adapter=new MyAdapter(listMain,MainActivity.this,false);
        lv.setAdapter(adapter);
    }

    private void init() {
        listMain=new ArrayList<>();
        for (String s:str){
            Bean bean = new Bean();
            bean.text=s;
//            Log.i("11111111111",s);
            listMain.add(bean);
//            Log.i("2222222222",listMain.toString());
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.all){
            check(true);
        }else if(v.getId()==R.id.bu){
            check(false);
        }else if(v.getId()==R.id.hide){
            isHide=isHide==true?false:true;
            hide(isHide);
        }
    }

    private void check(boolean flag){
        for (Bean bean:listMain){
            bean.isCheck=flag;
        }
        adapter.check();
    }

    private void hide(boolean isHide){
        Button btn= (Button) findViewById(R.id.hide);
        if(isHide){
            btn.setText("取消隐藏");
        }
        else{
            btn.setText("隐藏已选");
        }

        adapter.setHide(isHide);
        adapter.check();
    }
}
