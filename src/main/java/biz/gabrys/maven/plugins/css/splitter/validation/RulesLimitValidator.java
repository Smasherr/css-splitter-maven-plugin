/*
 * CSS Splitter Maven Plugin
 * http://css-splitter-maven-plugin.projects.gabrys.biz/
 *
 * Copyright (c) 2015 Adam Gabryś
 *
 * This file is licensed under the BSD 3-Clause (the "License").
 * You may not use this file except in compliance with the License.
 * You may obtain:
 * - a copy of the License at project page
 * - a template of the License at https://opensource.org/licenses/BSD-3-Clause
 */
package biz.gabrys.maven.plugins.css.splitter.validation;

import biz.gabrys.maven.plugins.css.splitter.counter.StyleSheetCounter;
import biz.gabrys.maven.plugins.css.splitter.css.types.StyleSheet;

public final class RulesLimitValidator implements StyleSheetValidator {

    private final StyleSheetCounter counter;
    private final int limit;

    public RulesLimitValidator(final int limit, final StyleSheetCounter counter) {
        this.limit = limit;
        this.counter = counter;
    }

    public void validate(final StyleSheet stylesheet) throws ValidationException {
        final int value = counter.count(stylesheet);
        if (value > limit) {
            throw new ValidationException(String.format("The number of style rules (%d) exceeded the allowable limit (%d)!", value, limit));
        }
    }
}
