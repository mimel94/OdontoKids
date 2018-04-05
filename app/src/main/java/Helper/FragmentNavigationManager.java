package Helper;



import android.support.v4.app.FragmentManager;

import com.mimel.odontokids.MainActivity;

import Interface.NavigationManager;

/**
 * Created by mimel on 3/04/18.
 */

public class FragmentNavigationManager implements NavigationManager {
    private static FragmentNavigationManager mInstance;

    private FragmentManager mFragmentManager;
    private MainActivity mainActivity;

    public static FragmentNavigationManager getmInstance(MainActivity mainActivity){
        if(mInstance == null)
            mInstance = new FragmentNavigationManager();
        mInstance.configure(mainActivity);

        return mInstance;
    }

    private void configure(MainActivity mainActivity) {
        mainActivity = mainActivity;
        mFragmentManager = mainActivity.getSupportFragmentManager();
    }

    @Override
    public void showFragment(String title) {

    }
}
