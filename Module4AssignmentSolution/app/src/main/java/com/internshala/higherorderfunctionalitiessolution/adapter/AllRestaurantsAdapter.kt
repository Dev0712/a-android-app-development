package com.internshala.higherorderfunctionalitiessolution.adapter

import android.content.Context
import android.os.AsyncTask
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.internshala.higherorderfunctionalitiessolution.R
import com.internshala.higherorderfunctionalitiessolution.database.RestaurantDatabase
import com.internshala.higherorderfunctionalitiessolution.database.RestaurantEntity
import com.internshala.higherorderfunctionalitiessolution.model.Restaurants
import com.squareup.picasso.Picasso

class AllRestaurantsAdapter(private var restaurants: ArrayList<Restaurants>, val context: Context) :
    RecyclerView.Adapter<AllRestaurantsAdapter.AllRestaurantsViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AllRestaurantsViewHolder {
        val itemView = LayoutInflater.from(p0.context)
            .inflate(R.layout.restaurants_custom_row, p0, false)

        return AllRestaurantsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


    override fun onBindViewHolder(p0: AllRestaurantsViewHolder, p1: Int) {
        val resObject = restaurants.get(p1)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            p0.resThumbnail.clipToOutline = true
        }
        p0.restaurantName.text = resObject.name
        p0.rating.text = resObject.rating
        val costForTwo = "${resObject.costForTwo.toString()}/person"
        p0.cost.text = costForTwo
        Picasso.get().load(resObject.imageUrl).error(R.drawable.res_image).into(p0.resThumbnail)


        val listOfFavourites = GetAllFavAsyncTask(context).execute().get()

        if (listOfFavourites.isNotEmpty() && listOfFavourites.contains(resObject.id.toString())) {
            p0.favImage.setImageResource(R.drawable.ic_action_fav_checked)
        } else {
            p0.favImage.setImageResource(R.drawable.ic_action_fav)
        }

        p0.favImage.setOnClickListener {
            val restaurantEntity = RestaurantEntity(
                resObject.id,
                resObject.name,
                resObject.rating,
                resObject.costForTwo.toString(),
                resObject.imageUrl
            )

            if (!DBAsyncTask(context, restaurantEntity, 1).execute().get()) {
                val async =
                    DBAsyncTask(context, restaurantEntity, 2).execute()
                val result = async.get()
                if (result) {
                    p0.favImage.setImageResource(R.drawable.ic_action_fav_checked)
                }
            } else {
                val async = DBAsyncTask(context, restaurantEntity, 3).execute()
                val result = async.get()

                if (result) {
                    p0.favImage.setImageResource(R.drawable.ic_action_fav)
                }
            }
        }

        p0.cardRestaurant.setOnClickListener {
            Toast.makeText(context, "Clicked on: ${p0.restaurantName.text}", Toast.LENGTH_SHORT)
                .show()
        }
    }

    class AllRestaurantsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val resThumbnail = view.findViewById(R.id.imgRestaurantThumbnail) as ImageView
        val restaurantName = view.findViewById(R.id.txtRestaurantName) as TextView
        val rating = view.findViewById(R.id.txtRestaurantRating) as TextView
        val cost = view.findViewById(R.id.txtCostForTwo) as TextView
        val cardRestaurant = view.findViewById(R.id.cardRestaurant) as CardView
        val favImage = view.findViewById(R.id.imgIsFav) as ImageView
    }

    class DBAsyncTask(context: Context, val restaurantEntity: RestaurantEntity, val mode: Int) :
        AsyncTask<Void, Void, Boolean>() {

        val db = Room.databaseBuilder(context, RestaurantDatabase::class.java, "res-db").build()

        override fun doInBackground(vararg params: Void?): Boolean {

            /*
            Mode 1 -> Check DB if the book is favourite or not
            Mode 2 -> Save the book into DB as favourite
            Mode 3 -> Remove the favourite book
            */

            when (mode) {

                1 -> {
                    val res: RestaurantEntity? =
                        db.restaurantDao().getRestaurantById(restaurantEntity.id.toString())
                    db.close()
                    return res != null
                }

                2 -> {
                    db.restaurantDao().insertRestaurant(restaurantEntity)
                    db.close()
                    return true
                }

                3 -> {
                    db.restaurantDao().deleteRestaurant(restaurantEntity)
                    db.close()
                    return true
                }
            }

            return false
        }

    }


    /*Since the outcome of the above background method is always a boolean, we cannot use the above here.
    * We require the list of favourite restaurants here and hence the outcome would be list.
    * For simplicity we obtain the list of restaurants and then extract their ids which is then compared to the ids
    * inside the list sent to the adapter */

    class GetAllFavAsyncTask(
        context: Context
    ) :
        AsyncTask<Void, Void, List<String>>() {

        val db = Room.databaseBuilder(context, RestaurantDatabase::class.java, "res-db").build()
        override fun doInBackground(vararg params: Void?): List<String> {

            val list = db.restaurantDao().getAllRestaurants()
            val listOfIds = arrayListOf<String>()
            for (i in list) {
                listOfIds.add(i.id.toString())
            }
            return listOfIds
        }
    }
}