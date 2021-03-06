package org.wwarn.mapcore.client.components.customwidgets;

/*
 * #%L
 * MapCore
 * %%
 * Copyright (C) 2013 - 2014 University of Oxford
 * %%
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * 3. Neither the name of the University of Oxford nor the names of its contributors
 *    may be used to endorse or promote products derived from this software without
 *    specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */


import org.wwarn.mapcore.client.common.types.Range;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.HasShowRangeHandlers;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ShowRangeHandler;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * User: raok
 * Date: 12-Feb-2010
 * Time: 18:13:17
 */
public class YuiDualSliderGwtWidgetImplWithLabelMarkers extends AbstractYuiSliderGwtWidgetWithLabelMarkers implements YuiDualSliderGwtWidget {

    //NOTE: This is dependant on the font size used for tick labels.

    public YuiDualSliderGwtWidgetImplWithLabelMarkers(Integer sliderWidthPx, Integer sliderHeightPx, Integer minRange, Integer maxRange, Integer labelInterval, Integer tickInterval) {
        super(minRange, maxRange, tickInterval, labelInterval);
        GWT.log("YuiDualSliderGwtWidgetImplWithLabelMarkers::constructor");

        yuiSliderGwtWidget = new YuiDualSliderGwtWidgetStandardImpl(sliderWidthPx, sliderHeightPx, minRange, maxRange, tickInterval);

        mainAbsolutePanel.add(yuiSliderGwtWidget, 0, 0);

        initWidget(mainAbsolutePanel);
    }

    @Override
    public HandlerRegistration addShowRangeHandler(ShowRangeHandler<Integer> integerShowRangeHandler) {
        return ((HasShowRangeHandlers<Integer>)yuiSliderGwtWidget).addShowRangeHandler(integerShowRangeHandler);
    }

    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Range<Integer>> integerRangeValueChangeHandler) {
        return ((HasValueChangeHandlers<Range<Integer>>)yuiSliderGwtWidget).addValueChangeHandler(integerRangeValueChangeHandler);
    }

    public void setRange(Integer minYear, Integer maxYear) {
        ((YuiDualSliderGwtWidget)yuiSliderGwtWidget).setRange(minYear, maxYear);
    }


}
