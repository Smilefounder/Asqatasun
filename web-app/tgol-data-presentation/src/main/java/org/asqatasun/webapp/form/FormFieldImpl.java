/*
 * Asqatasun - Automated webpage assessment
 * Copyright (C) 2008-2019  Asqatasun.org
 *
 * This file is part of Asqatasun.
 *
 * Asqatasun is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contact us by mail: asqatasun AT asqatasun DOT org
 */
package org.asqatasun.webapp.form;

/**
 *
 * @author jkowalczyk
 */
public abstract class FormFieldImpl implements FormField {

    @Override
    public abstract boolean checkParameters(String value);

    private String i18nKey=null;
    @Override
    public String getI18nKey() {
        return this.i18nKey;
    }

    @Override
    public void setI18nKey(String i18nKey) {
        this.i18nKey = i18nKey;
    }

    private String value=null;
    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    private String errorI18nKey = null;
    @Override
    public String getErrorI18nKey() {
        return this.errorI18nKey;
    }

    @Override
    public void setErrorI18nKey(String errorI18nKey) {
        this.errorI18nKey = errorI18nKey;
    }

}
