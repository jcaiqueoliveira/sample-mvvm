package sample.kanda.mvvm.detail

/**
 * Created by jcosilva on 2/15/2018.
 */
data class DetailedContact(
        val id: Int,
        val name: String,
        val email: String,
        val phone: String,
        val companyName: String,
        val cnpj: String,
        val isMei: Boolean,
        val data: String
)

