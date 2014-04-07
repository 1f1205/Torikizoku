package com.Ichif1205.torikizoku.enemy;

import android.content.res.Resources;

import com.Ichif1205.torikizoku.R;

/**
 * Marioクラス.
 *
 * @author wkodate
 *
 */
public class Mario extends BaseEnemy {

    /**
     * コンストラクタ.
     *
     * @param res
     *            リソース.
     * @param x
     *            x座標.
     * @param y
     *            y座標.
     */
    public Mario(final Resources res, final int x, final int y) {
        super(res, x, y);
    }

    @Override
    protected final int getEnemyResource() {
        return R.drawable.mario;
    }

    /**
     * Playerの位置を更新.
     */
    @Override
    public final void updatePosition() {
        // TODO 画面の端に行った時の処理
        posX += dx;
        // y方向の動き
        posY = (int) Math.abs(20 * Math.sin(posX * (Math.PI / 180)));
    }
}