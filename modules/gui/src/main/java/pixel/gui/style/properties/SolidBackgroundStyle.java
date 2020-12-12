/*
 * This software is available under Apache License
 * Copyright (c) 2020
 */

package pixel.gui.style.properties;

import lombok.*;
import pixel.graphics.Color;
import pixel.gui.style.StyleProperty;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class SolidBackgroundStyle extends BackgroundStyle {

    private Color color;

    /**
     * Merge property into existing values (when applicable)
     *
     * @param other
     */
    @Override
    public void merge(StyleProperty other) {
        if (other instanceof SolidBackgroundStyle) {
            var o = (SolidBackgroundStyle) other;
            this.color = o.color != null ? o.color : this.color;
        }
    }

    /**
     * Set missing property values
     *
     * @return
     */
    @Override
    public void setUnassignedProperties() {
        if (this.color == null) this.color = Color.TRANSPARENT;
    }

    @Override
    public StyleProperty clone() {
        return SolidBackgroundStyle.builder()
                .color(new Color(color))
                .build();
    }

    /**
     * @return
     */
    @Override
    public String getName() {
        return NAME;
    }
}
