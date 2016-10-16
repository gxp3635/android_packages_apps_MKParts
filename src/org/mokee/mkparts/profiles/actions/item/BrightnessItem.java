/*
 * Copyright (C) 2015 The CyanogenMod Project
 * Copyright (C) 2015 The MoKee Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.mokee.mkparts.profiles.actions.item;

import org.mokee.mkparts.R;
import org.mokee.mkparts.profiles.actions.ItemListAdapter;

import mokee.profiles.BrightnessSettings;

public class BrightnessItem extends BaseItem {
    BrightnessSettings mSettings;

    public BrightnessItem(BrightnessSettings brightnessSettings) {
        if (brightnessSettings == null) {
            brightnessSettings = new BrightnessSettings();
        }
        mSettings = brightnessSettings;
    }

    @Override
    public ItemListAdapter.RowType getRowType() {
        return ItemListAdapter.RowType.BRIGHTNESS_ITEM;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getTitle() {
        return getString(R.string.profile_brightness_title);
    }

    @Override
    public String getSummary() {
        if (mSettings.isOverride()) {
            return getContext().getResources().getString(
                    R.string.profile_brightness_override_summary,
                    (int)((mSettings.getValue() * 100f)/255));
        }
        return getString(R.string.profile_action_none);
    }

    public BrightnessSettings getSettings() {
        return mSettings;
    }
}
