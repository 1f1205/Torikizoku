package com.Ichif1205.torikizoku;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.Ichif1205.torikizoku.enemy.BaseEnemy;
import com.Ichif1205.torikizoku.enemy.EnemyFactory;
import com.Ichif1205.torikizoku.player.BasePlayer;
import com.Ichif1205.torikizoku.player.PlayerFactory;
import com.Ichif1205.torikizoku.utils.Const;

/**
 * SurfaceViewの処理を書くメインクラス.
 * 
 * @author wkodate
 * 
 */
public class MainSurfaceView extends SurfaceView implements
        SurfaceHolder.Callback, Runnable {

    /**
     * ログ出力用のタグ.
     */
    private static final String TAG = MainSurfaceView.class.getSimpleName();

    /**
     * SurfaceView描画のインターフェース.
     */
    private SurfaceHolder surfaceHolder;

    /**
     * アプリケーションの環境情報を受け渡すためのインターフェース.
     */
    private Context mContext;

    /**
     * UIを操作するためのクラス.
     */
    private Handler mHandler;

    /**
     * スレッドクラス.
     */
    private Thread mThread;

    /**
     * 描画の色やスタイルを決定するクラス.
     */
    private Paint mPaint;

    /**
     * 2次元描画を行うクラス.
     */
    private Canvas mCanvas;

    /**
     * Playerクラス.
     */
    private BasePlayer mPlayer;

    /**
     * Playerクラス.
     */
    private BaseEnemy mEnemy;

    /**
     * 背景用のBitmapクラス.
     */
    private Bitmap mBitmapBackground;

    /**
     * Player用のBitmapクラス.
     */
    private Bitmap mBitmapPlayer;

    /**
     * Enemy用のBitmapクラス.
     */
    private Bitmap mBitmapEnemy;

    /**
     * 画面幅.
     */
    private long windowWidth;

    /**
     * 画面高さ.
     */
    private long windowHeight;

    /**
     * PlayerのBitmapを最初に表示させる位置のためのウィンドウ幅に対する割合.
     */
    private static final double DEFAULT_PLAYER_WIDTH_RATE = 0.5;

    /**
     * PlayerのBitmapを最初に表示させる位置のためのウィンドウ高さに対する割合. TODO ステージに合わせて値を変えれるように変更.
     * TODO 端末によって位置がずれる.
     */
    private static final double DEFAULT_PLAYER_HEIGHT_RATE = 0.74;

    private static final double DEFAULT_ENEMY_WIDTH_RATE = 0.1;

    private static final double DEFAULT_ENEMY_HEIGHT_RATE = 0.74;
    /**
     * 実行中かどうかの情報.
     */
    private boolean isExecuted;

    /**
     * コンストラクタ.
     * 
     * @param context
     *            アプリケーション情報.
     */
    public MainSurfaceView(final Context context) {
	super(context);
	this.mContext = context;
	surfaceHolder = getHolder();
	surfaceHolder.addCallback(this);
	Log.d(TAG, "Constractor");
    }

    /**
     * コンストラクタ.
     * 
     * @param context
     *            アプリケーション情報.
     * @param attrs
     *            xml属性.
     */
    public MainSurfaceView(final Context context, final AttributeSet attrs) {
	super(context, attrs);
	this.mContext = context;
	surfaceHolder = getHolder();
	surfaceHolder.addCallback(this);
	Log.d(TAG, "Constructor");
    }

    @Override
    public final void surfaceCreated(final SurfaceHolder holder) {
	Log.d(TAG, "Create SurfaceView");
	isExecuted = true;
	init();
	mThread.start();
    }

    @Override
    public final void surfaceChanged(final SurfaceHolder holder,
	    final int format, final int width, final int height) {
	Log.d(TAG, "Change Surface");
    }

    @Override
    public final void surfaceDestroyed(final SurfaceHolder holder) {
	Log.d(TAG, "Destroy SurfaceView");
	mThread = null;
	isExecuted = false;
    }

    /**
     * 初期化用メソッド.
     */
    public final void init() {
	Log.d(TAG, "init");

	mThread = new Thread(this);
	// 画面の大きさを取得
	windowWidth = getWidth();
	windowHeight = getHeight();

	mPaint = new Paint();
	mPaint.setAntiAlias(true);

	Resources resource = getResources();

	// 背景画像をセット
	drawBackground(resource);

	// Playerのインスタンス作成
	mPlayer = PlayerFactory.create(Const.PLAYER_TYPE_GOOMBA, resource,
	        (int) (windowWidth * DEFAULT_PLAYER_WIDTH_RATE),
	        (int) (windowHeight * DEFAULT_PLAYER_HEIGHT_RATE));
	mBitmapPlayer = mPlayer.createBitmap();
	setOnTouchListener(mPlayer);

	// Enemyのインスタンス作成
	mEnemy = EnemyFactory.create(Const.PLAYER_TYPE_MARIO, resource,
	        (int) (windowWidth * DEFAULT_ENEMY_WIDTH_RATE),
	        (int) (windowHeight * DEFAULT_ENEMY_HEIGHT_RATE));
	mBitmapEnemy = mEnemy.createBitmap();

	mHandler = new Handler();
    }

    @Override
    public final void run() {
	Log.d(TAG, "run");
	while (isExecuted) {
	    onDraw();
	}
    }

    /**
     * 描画全体を管理するメソッド.
     */
    public final void onDraw() {
	mCanvas = getHolder().lockCanvas();
	mCanvas.drawBitmap(mBitmapBackground, 0, 0, null);
	mPlayer.drawPlayer(mCanvas, mPaint);
	mEnemy.drawEnemy(mCanvas, mPaint);
	getHolder().unlockCanvasAndPost(mCanvas);
    }

    /**
     * 背景を描画するクラス.
     * 
     * @param res
     *            リソース.
     */
    public final void drawBackground(final Resources res) {
	mBitmapBackground = BitmapFactory.decodeResource(getResources(),
	        R.drawable.background);
	mBitmapBackground = Bitmap.createScaledBitmap(mBitmapBackground,
	        (int) windowWidth, (int) windowHeight, true);

    }
}