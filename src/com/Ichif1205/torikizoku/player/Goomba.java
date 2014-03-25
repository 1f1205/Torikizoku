package com.Ichif1205.torikizoku.player;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;

import com.Ichif1205.torikizoku.R;

/**
 * Goombaクラス.
 * 
 * @author wkodate
 * 
 */
public class Goomba extends BasePlayer {

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
    public Goomba(final Resources res, final int x, final int y) {
	super(res, x, y);
    }

    @Override
    protected final int getPlayerResource() {
	return R.drawable.goomba;
    }

    /**
     * Playerの位置を更新.
     */
    public final void updatePosition() {
	// TODO 画面の端に行った時の処理
	posX += dx;
    }

    @Override
    public final boolean onTouch(final View v, final MotionEvent event) {
	if (event.getAction() == MotionEvent.ACTION_UP) {
	    dx = -dx;
	}
	return true;
    }

}