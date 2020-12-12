/*
 * This software is available under Apache License
 * Copyright (c) 2020
 */

package pixel.gui.style.properties;

import lombok.*;
import pixel.gui.style.StyleProperty;
import pixel.gui.style.model.DisplayUnit;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class OriginStyle extends StyleProperty {

    private static final String NAME = "originStyle";

    private DisplayUnit x;
    private DisplayUnit y;

    /**
     * Merge property into existing values (when applicable)
     *
     * @param other
     */
    @Override
    public void merge(StyleProperty other) {
        if (other instanceof OriginStyle) {
            var o = (OriginStyle) other;
            this.x = o.x != null ? o.x : this.x;
            this.y = o.y != null ? o.y : this.y;
        }
    }

    /**
     * Set missing property values
     *
     * @return
     */
    @Override
    public void setUnassignedProperties() {
        if (this.x == null) this.x = DisplayUnit.builder().value(0f).type(DisplayUnit.Type.PERCENTAGE).build();
        if (this.y == null) this.y = DisplayUnit.builder().value(0f).type(DisplayUnit.Type.PERCENTAGE).build();
    }

    @Override
    public StyleProperty clone() {
        return OriginStyle.builder()
                .x(x != null ? x.clone() : null)
                .y(y != null ? y.clone() : null)
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
