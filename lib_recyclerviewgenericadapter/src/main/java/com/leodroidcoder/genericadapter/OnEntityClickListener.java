/*
 * Copyright (C) 2017 Leonid Ustenko Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.leodroidcoder.genericadapter;

/**
 * Listener, which triggers an object associated with the item,
 * rather than position, on recycler item click.
 *
 * @param <T> object click listener
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 1.0.0
 */
public interface OnEntityClickListener<T> extends BaseRecyclerListener {

    /**
     * Item has been clicked.
     * Here you retrieve an entity associated with the clicked item and you are free to use it in any way.
     *
     * @param item object associated with the clicked item.
     * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
     * @since 0.1.0
     */
    void onItemClicked(T item);
}