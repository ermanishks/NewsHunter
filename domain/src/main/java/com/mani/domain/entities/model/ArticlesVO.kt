package com.mani.domain.entities.model

/**
 * Created by Manish Kumar
 */
data class ArticlesVO(val source: SourceVO,
                      val author:String?,
                      val title:String?,
                      val description:String?,
                      val url:String?,
                      val urlToImage:String?,
                      val publishedAt:String?,
                      val content:String?) {

    fun getFormattedDate():String{
        return publishedAt+"MANISH";
    }
}