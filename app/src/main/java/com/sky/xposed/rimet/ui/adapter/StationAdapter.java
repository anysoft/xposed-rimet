/*
 * Copyright (c) 2020 The sky Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sky.xposed.rimet.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sky.xposed.rimet.data.model.StationModel;
import com.sky.xposed.ui.base.BaseListAdapter;
import com.sky.xposed.ui.view.TextItemView;

/**
 * Created by sky on 2020-03-22.
 */
public class StationAdapter extends BaseListAdapter<StationModel> {

    public StationAdapter(Context context) {
        super(context);
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup parent, int viewType) {

        TextItemView itemView = new TextItemView(getContext());
        itemView.getNameView().setSingleLine(false);
        itemView.getNameView().setMaxLines(2);

        return itemView;
    }

    @Override
    public ViewHolder<StationModel> onCreateViewHolder(View view, int viewType) {
        return new StationHolder(view, this);
    }

    private class StationHolder extends ViewHolder<StationModel> {

        private TextItemView mTextItemView;

        StationHolder(View itemView, BaseListAdapter<StationModel> baseListAdapter) {
            super(itemView, baseListAdapter);
        }

        @Override
        public void onInitialize() {
            super.onInitialize();
            mTextItemView = (TextItemView) mItemView;
        }

        @Override
        public void onBind(int position, int viewType) {

            StationModel item = getItem(position);

            mTextItemView.setName(item.getDesc());
            mTextItemView.setDesc(item.getName());
        }
    }
}
