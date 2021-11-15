package com.example.testsecondtry.retrofit

data class Photos (
    val results: List<Result>,
    val total: Int,
    val total_pages: Int
) {
    data class Result(
        val alt_description: String,
        val blur_hash: String,
        val categories: List<Any>,
        val color: String,
        val created_at: String,
        val current_user_collections: List<Any>,
        val description: String,
        val height: Int,
        val id: String,
        val liked_by_user: Boolean,
        val likes: Int,
        val links: Links,
        val promoted_at: String,
        val sponsorship: Any,
        val tags: List<Tag>,
        val topic_submissions: TopicSubmissions,
        val updated_at: String,
        val urls: Urls,
        val user: User,
        val width: Int
    ) {
        data class Links(
            val download: String,
            val download_location: String,
            val html: String,
            val self: String
        )

        data class Tag(
            val source: Source,
            val title: String,
            val type: String
        ) {
            data class Source(
                val ancestry: Ancestry,
                val cover_photo: CoverPhoto,
                val description: String,
                val meta_description: String,
                val meta_title: String,
                val subtitle: String,
                val title: String
            ) {
                data class Ancestry(
                    val category: Category,
                    val subcategory: Subcategory,
                    val type: Type
                ) {
                    data class Category(
                        val pretty_slug: String,
                        val slug: String
                    )

                    data class Subcategory(
                        val pretty_slug: String,
                        val slug: String
                    )

                    data class Type(
                        val pretty_slug: String,
                        val slug: String
                    )
                }

                data class CoverPhoto(
                    val alt_description: String,
                    val blur_hash: String,
                    val categories: List<Any>,
                    val color: String,
                    val created_at: String,
                    val current_user_collections: List<Any>,
                    val description: String,
                    val height: Int,
                    val id: String,
                    val liked_by_user: Boolean,
                    val likes: Int,
                    val links: Links,
                    val promoted_at: String,
                    val sponsorship: Any,
                    val topic_submissions: TopicSubmissions,
                    val updated_at: String,
                    val urls: Urls,
                    val user: User,
                    val width: Int
                ) {
                    data class Links(
                        val download: String,
                        val download_location: String,
                        val html: String,
                        val self: String
                    )


                    data class Urls(
                        val full: String,
                        val raw: String,
                        val regular: String,
                        val small: String,
                        val thumb: String
                    )

                    data class User(
                        val accepted_tos: Boolean,
                        val bio: Any,
                        val first_name: String,
                        val for_hire: Boolean,
                        val id: String,
                        val instagram_username: Any,
                        val last_name: String,
                        val links: Links,
                        val location: Any,
                        val name: String,
                        val portfolio_url: String,
                        val profile_image: ProfileImage,
                        val social: Social,
                        val total_collections: Int,
                        val total_likes: Int,
                        val total_photos: Int,
                        val twitter_username: Any,
                        val updated_at: String,
                        val username: String
                    ) {
                        data class Links(
                            val followers: String,
                            val following: String,
                            val html: String,
                            val likes: String,
                            val photos: String,
                            val portfolio: String,
                            val self: String
                        )

                        data class ProfileImage(
                            val large: String,
                            val medium: String,
                            val small: String
                        )

                        data class Social(
                            val instagram_username: Any,
                            val paypal_email: Any,
                            val portfolio_url: String,
                            val twitter_username: Any
                        )
                    }
                }
            }
        }

        data class TopicSubmissions(
            val travel: Travel
        ) {
            data class Travel(
                val approved_on: String,
                val status: String
            )
        }

        data class Urls(
            val full: String,
            val raw: String,
            val regular: String,
            val small: String,
            val thumb: String
        )

        data class User(
            val accepted_tos: Boolean,
            val bio: String,
            val first_name: String,
            val for_hire: Boolean,
            val id: String,
            val instagram_username: String,
            val last_name: String,
            val links: Links,
            val location: String,
            val name: String,
            val portfolio_url: String,
            val profile_image: ProfileImage,
            val social: Social,
            val total_collections: Int,
            val total_likes: Int,
            val total_photos: Int,
            val twitter_username: String,
            val updated_at: String,
            val username: String
        ) {
            data class Links(
                val followers: String,
                val following: String,
                val html: String,
                val likes: String,
                val photos: String,
                val portfolio: String,
                val self: String
            )

            data class ProfileImage(
                val large: String,
                val medium: String,
                val small: String
            )

            data class Social(
                val instagram_username: String,
                val paypal_email: Any,
                val portfolio_url: String,
                val twitter_username: String
            )
        }
    }
}