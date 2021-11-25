package com.example.testsecondtry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testsecondtry.adaptors.RVAdapter
import com.example.testsecondtry.model.MyViewModel
import com.example.testsecondtry.retrofit.APIClient
import com.example.testsecondtry.retrofit.APIInterface
import com.example.testsecondtry.retrofit.Photos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BrowserFragment : Fragment() {

    lateinit var rvMain: RecyclerView
    lateinit var etSearch: EditText
    lateinit var btSearch: ImageView
    private lateinit var llBottom: LinearLayout
    private lateinit var ivMain: ImageView
    lateinit var viewModel: MyViewModel

    private lateinit var info: ArrayList<Photos.Result>
    var apiInterface = APIClient().getClient()?.create(APIInterface::class.java)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_browser, container, false)

        rvMain = view.findViewById(R.id.rvMain)
        etSearch = view.findViewById(R.id.etSearch)
        btSearch = view.findViewById(R.id.btSearch)
        llBottom = view.findViewById(R.id.llBottom)
        ivMain = view.findViewById(R.id.ivMain)
        ivMain.setOnClickListener { closeImg() }
        info = arrayListOf()

        rvMain.adapter = RVAdapter(info, this)
        rvMain.layoutManager = LinearLayoutManager(requireContext())
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        btSearch.setOnClickListener {
            if (etSearch.text.isNotEmpty()) {

                requestAPI()
                etSearch.text.clear()
                etSearch.clearFocus()
                info.clear()

            } else {
                Toast.makeText(activity, "please add a name", Toast.LENGTH_SHORT)
                    .show()

            }
        }

        return view
    }

    private fun requestAPI() {
        apiInterface?.getPhotoData(etSearch.text.toString())?.enqueue(object : Callback<Photos?> {
            override fun onResponse(call: Call<Photos?>, response: Response<Photos?>) {
                for (photo in response.body()?.results!!) {
                    info.add(photo!!)
                }
                rvMain.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<Photos?>, t: Throwable) {
            }

        })
    }


    fun openImg(link: String) {
        Glide.with(this).load(link).into(ivMain)
        ivMain.isVisible = true
        rvMain.isVisible = false
        llBottom.isVisible = false
    }

    private fun closeImg() {
        ivMain.isVisible = false
        rvMain.isVisible = true
        llBottom.isVisible = true
    }
    fun addPhoto(photoTitle: String, photoLink: String){
        viewModel.addPhoto(photoTitle,photoLink)
    }

}