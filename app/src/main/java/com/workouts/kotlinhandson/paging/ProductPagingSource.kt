package com.workouts.kotlinhandson.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState

class ProductPagingSource : PagingSource<Int, Product>() {

    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, Product> {
        try {
            // Start refresh at page 1 if undefined.
            val nextPageNumber = params.key ?: 1
            /*return LoadResult.Page(
                data = response.users,
                prevKey = null, // Only paging forward.
                nextKey = response.nextPageNumber
            )*/
        } catch (e: Exception) {
            // Handle errors in this block and return LoadResult.Error if it is an
            // expected error (such as a network failure).
        }
        throw Exception()
    }

    override fun getRefreshKey(state: PagingState<Int, Product>): Int? {
        TODO("Not yet implemented")
    }
}