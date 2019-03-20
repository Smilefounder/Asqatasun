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
package org.asqatasun.webapp.entity.service.option;

import java.util.Collection;
import org.asqatasun.sdk.entity.service.GenericDataService;
import org.asqatasun.webapp.entity.option.Option;
import org.asqatasun.webapp.entity.option.OptionElement;
import org.asqatasun.webapp.entity.user.User;

/**
 *
 * @author jkowalczyk
 */
public interface OptionElementDataService extends GenericDataService<OptionElement, Long> {

    /**
     * 
     * @param value
     * @param option
     * @return 
     */
    OptionElement getOptionElementFromValueAndOption(String value, Option option);
    
    /**
     * 
     * @param user
     * @param optionFamilyCode
     * @return 
     */
    Collection<OptionElement> getOptionElementFromUserAndFamilyCode(User user, String optionFamilyCode);
    
    /**
     * 
     * @param user
     * @return 
     */
    Collection<OptionElement> getOptionElementFromUser(User user);
    
}
