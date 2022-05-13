package martinez.miguel.disneyworldlista

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIservice {
    @GET
    fun getdisneyforlist(@Url url: String):Response<disneyDataClass>
}