/*
 * This software is available under Apache License
 * Copyright (c) 2020
 */

package pixel.content;

/**
 * @author João Filipe Alves
 */
public interface ContentImporter<T> {
    T process(ImportContext ctx);
}
