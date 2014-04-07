package com.Ichif1205.torikizoku.player;

import android.content.res.Resources;

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
    @Override
    public final void updatePosition() {
        // TODO 画面の端に行った時の処理
        posX += dx;
    }

    @Override
    public final void upAction() {
        dx = -dx;
    }

    @Override
    public void downAction() {
    }

    @Override
    public void moveAction() {
    }

    @Override
    public void cancelAction() {
    }

}