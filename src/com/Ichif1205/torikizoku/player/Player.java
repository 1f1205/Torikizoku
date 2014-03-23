package com.Ichif1205.torikizoku.player;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.Ichif1205.torikizoku.R;

/**
 * Playerクラス.
 * 
 * @author wkodate
 * 
 */
public class Player {

    /**
     * x座標.
     */
    public int posX;

    /**
     * y座標.
     */
    public int posY;

    /**
     * x方向の速度.
     */
    public int dx;

    /**
     * ビットマップクラス.
     */
    private Bitmap mBitmap;


    /**
     * 幅.
     */
    private int width;

    /**
     * 高さ.
     */
    private int height;

    /**
     * デフォルトのx方向速度.
     */
    public static final int DEFAULT_PLYER_DX = -6;

    /**
     * デフォルトの幅.
     */
    public static final int DEFAULT_PLYER_WIDTH = 72;

    /**
     * デフォルトの高さ.
     */
    public static final int DEFAULT_PLYER_HEIGHT = 72;

    /**
     * コンストラクタ.
     * 
     * @param res
     *            リソース.
     * @param x
     *            x座標.
     * @param y
     *            z座標.
     */
    public Player(final Resources res, final int x, final int y) {
	// TODO 変更がありそうなら引数に追加
	dx = DEFAULT_PLYER_DX;
	width = DEFAULT_PLYER_WIDTH;
	height = DEFAULT_PLYER_HEIGHT;
	posX = x;
	posY = y;
	mBitmap = BitmapFactory.decodeResource(res, R.drawable.goomba);
    }

    /**
     * Bitmapを作成して返す.
     * 
     * @return Playerのbitmap
     */
    public final Bitmap createBitmap() {
	return Bitmap.createScaledBitmap(mBitmap, width, height, true);
    }

    /**
     * Playerの位置を更新.
     */
    public final void updatePosition() {
	posX += dx;
    }

}