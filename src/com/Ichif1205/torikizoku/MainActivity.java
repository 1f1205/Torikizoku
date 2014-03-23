package com.Ichif1205.torikizoku;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Mainアクティビティ.
 * 
 * @author wkodate
 * 
 */
public class MainActivity extends Activity {

    /**
     * ログ出力用タグ.
     */
    private static final String TAG = MainActivity.class.getSimpleName();

    /**
     * MainSurfaceView.
     */
    private MainSurfaceView mainSurfaceView;

    @Override
    protected final void onCreate(final Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	Log.d(TAG, "onCreate");
	setContentView(R.layout.activity_main);

	mainSurfaceView = (MainSurfaceView) findViewById(R.id.MainSurfaceView_id);
	Log.d(TAG, "Start FindView");
    }

    @Override
    protected final void onResume() {
	super.onResume();
	Log.d(TAG, "onResume");
    }

    @Override
    protected final void onPause() {
	super.onPause();
    }

    @Override
    protected final void onRestart() {
	super.onRestart();
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
	/**
	 * コンストラクタ.
	 */
	public PlaceholderFragment() {
	}

	@Override
	public final View onCreateView(final LayoutInflater inflater,
	        final ViewGroup container, final Bundle savedInstanceState) {
	    View rootView = inflater.inflate(R.layout.fragment_main, container,
		    false);
	    return rootView;
	}
    }
}
