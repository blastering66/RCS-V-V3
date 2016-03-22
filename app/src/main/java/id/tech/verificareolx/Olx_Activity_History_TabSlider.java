package id.tech.verificareolx;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * Created by macbook on 2/16/16.
 */
public class Olx_Activity_History_TabSlider extends AppCompatActivity {
    onRefresh refreshListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_tabslider);

        ActionBar ac = getSupportActionBar();
        ac.setDisplayHomeAsUpEnabled(true);
        ac.setTitle("History");

        refreshListener = new Olx_SlidingTabsFragment();

        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
//		TestSlidingFragment fragment = new TestSlidingFragment();
        Olx_SlidingTabsFragment fragment = new Olx_SlidingTabsFragment();
        t.replace(R.id.content_fragment	, fragment);
        t.commit();
    }

    public interface onRefresh{
        public void loadData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.refresh_history, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                overridePendingTransition(android.R.anim.fade_in,R.anim.slide_out_right);
                break;
            case R.id.action_refresh:
                refreshListener.loadData();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(android.R.anim.fade_in, R.anim.slide_out_right);
    }
}
