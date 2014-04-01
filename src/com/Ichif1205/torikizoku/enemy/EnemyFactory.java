package com.Ichif1205.torikizoku.enemy;

import android.content.res.Resources;

/**
 * Enemyオブジェクトを生成するクラス.
 * 
 * @author wkodate
 * 
 */
public final class EnemyFactory {

    /**
     * インスタンスを生成させない.
     */
    private EnemyFactory() {

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
    public static BaseEnemy create(final int type, final Resources res,
	    final int width, final int height) {
	final BaseEnemy enemy;

	// if type == 1
	enemy = new Mario(res, width, height);

	return enemy;
    }
}