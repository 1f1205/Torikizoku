package com.Ichif1205.torikizoku.player;

import android.content.res.Resources;

/**
 * Playerオブジェクトを生成するクラス.
 * 
 * @author wkodate
 * 
 */
public final class PlayerFactory {

    /**
     * インスタンスを生成させない.
     */
    private PlayerFactory() {

    }

    /**
     * Playerのインスタンスを生成.
     * 
     * @param type
     *            Playerの種類.
     * @param res
     *            リソース.
     * @param width
     *            幅
     * @param height
     *            高さ
     * @return Playerインスタンス.
     */
    public static BasePlayer create(final int type, final Resources res,
	    final int width, final int height) {
	final BasePlayer player;

	// if type == 1
	player = new Goomba(res, width, height);

	return player;
    }
}