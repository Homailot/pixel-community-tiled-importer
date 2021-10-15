package org.pixel.tiled.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.pixel.graphics.render.SpriteBatch;
import org.pixel.tiled.content.Layer;

class DrawStrategyTest {
    Layer layer;
    SpriteBatch spriteBatch;
    long[][] tiles = new long[2][2];

    @BeforeEach
    void setup() {
        layer = Mockito.mock(Layer.class);
        spriteBatch = Mockito.mock(SpriteBatch.class);

        Mockito.when(layer.getWidth()).thenReturn(2);
        Mockito.when(layer.getHeight()).thenReturn(2);
        Mockito.when(layer.getTiles()).thenReturn(tiles);
    }

    @Test
    void rightDownStrategy() {
        RightDownStrategy rightDownStrategy = Mockito.spy(new RightDownStrategy());
        Mockito.doNothing().when(rightDownStrategy).drawTile(Mockito.any(), Mockito.any(), Mockito.anyInt(), Mockito.anyInt());

        InOrder inOrder = Mockito.inOrder(rightDownStrategy);

        rightDownStrategy.draw(spriteBatch, layer);

        inOrder.verify(rightDownStrategy).drawTile(Mockito.same(spriteBatch), Mockito.same(layer), Mockito.eq(0), Mockito.eq(0));
        inOrder.verify(rightDownStrategy).drawTile(Mockito.same(spriteBatch), Mockito.same(layer), Mockito.eq(1), Mockito.eq(0));
        inOrder.verify(rightDownStrategy).drawTile(Mockito.same(spriteBatch), Mockito.same(layer), Mockito.eq(0), Mockito.eq(1));
        inOrder.verify(rightDownStrategy).drawTile(Mockito.same(spriteBatch), Mockito.same(layer), Mockito.eq(1), Mockito.eq(1));
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    void leftDownStrategy() {
        LeftDownStrategy strategy = Mockito.spy(new LeftDownStrategy());
        Mockito.doNothing().when(strategy).drawTile(Mockito.any(), Mockito.any(), Mockito.anyInt(), Mockito.anyInt());

        InOrder inOrder = Mockito.inOrder(strategy);

        strategy.draw(spriteBatch, layer);

        inOrder.verify(strategy, Mockito.times(0)).drawTile(Mockito.same(spriteBatch), Mockito.same(layer), Mockito.eq(3), Mockito.eq(0));
        inOrder.verify(strategy).drawTile(Mockito.same(spriteBatch), Mockito.same(layer), Mockito.eq(1), Mockito.eq(0));
        inOrder.verify(strategy).drawTile(Mockito.same(spriteBatch), Mockito.same(layer), Mockito.eq(0), Mockito.eq(0));
        inOrder.verify(strategy).drawTile(Mockito.same(spriteBatch), Mockito.same(layer), Mockito.eq(1), Mockito.eq(1));
        inOrder.verify(strategy).drawTile(Mockito.same(spriteBatch), Mockito.same(layer), Mockito.eq(0), Mockito.eq(1));
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    void leftUpStrategy() {
        LeftUpStrategy strategy = Mockito.spy(new LeftUpStrategy());
        Mockito.doNothing().when(strategy).drawTile(Mockito.any(), Mockito.any(), Mockito.anyInt(), Mockito.anyInt());

        InOrder inOrder = Mockito.inOrder(strategy);

        strategy.draw(spriteBatch, layer);

        inOrder.verify(strategy, Mockito.times(0)).drawTile(Mockito.same(spriteBatch), Mockito.same(layer), Mockito.eq(3), Mockito.eq(3));
        inOrder.verify(strategy, Mockito.times(0)).drawTile(Mockito.same(spriteBatch), Mockito.same(layer), Mockito.eq(3), Mockito.eq(0));
        inOrder.verify(strategy, Mockito.times(0)).drawTile(Mockito.same(spriteBatch), Mockito.same(layer), Mockito.eq(0), Mockito.eq(3));
        inOrder.verify(strategy).drawTile(Mockito.same(spriteBatch), Mockito.same(layer), Mockito.eq(1), Mockito.eq(1));
        inOrder.verify(strategy).drawTile(Mockito.same(spriteBatch), Mockito.same(layer), Mockito.eq(0), Mockito.eq(1));
        inOrder.verify(strategy).drawTile(Mockito.same(spriteBatch), Mockito.same(layer), Mockito.eq(1), Mockito.eq(0));
        inOrder.verify(strategy).drawTile(Mockito.same(spriteBatch), Mockito.same(layer), Mockito.eq(0), Mockito.eq(0));
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    void rightUpStrategy() {
        RightUpStrategy strategy = Mockito.spy(new RightUpStrategy());
        Mockito.doNothing().when(strategy).drawTile(Mockito.any(), Mockito.any(), Mockito.anyInt(), Mockito.anyInt());

        InOrder inOrder = Mockito.inOrder(strategy);

        strategy.draw(spriteBatch, layer);

        inOrder.verify(strategy, Mockito.times(0)).drawTile(Mockito.same(spriteBatch), Mockito.same(layer), Mockito.eq(0), Mockito.eq(3));
        inOrder.verify(strategy).drawTile(Mockito.same(spriteBatch), Mockito.same(layer), Mockito.eq(0), Mockito.eq(1));
        inOrder.verify(strategy).drawTile(Mockito.same(spriteBatch), Mockito.same(layer), Mockito.eq(1), Mockito.eq(1));
        inOrder.verify(strategy).drawTile(Mockito.same(spriteBatch), Mockito.same(layer), Mockito.eq(0), Mockito.eq(0));
        inOrder.verify(strategy).drawTile(Mockito.same(spriteBatch), Mockito.same(layer), Mockito.eq(1), Mockito.eq(0));
        inOrder.verifyNoMoreInteractions();
    }
}