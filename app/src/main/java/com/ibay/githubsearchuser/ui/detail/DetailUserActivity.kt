package com.ibay.githubsearchuser.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.ibay.githubsearchuser.databinding.ActivityDetailUserBinding

class DetailUserActivity : AppCompatActivity() {
    companion object {
        const val USERNAME = "username"
    }

    private lateinit var binding: ActivityDetailUserBinding
    private lateinit var viewModel: DetailUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(USERNAME)
        val bundle = Bundle()
        bundle.putString(USERNAME, username)

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(DetailUserViewModel::class.java)

        username?.let { viewModel.setUserDetail(it) }
        viewModel.getUserDetail().observe(this, {
            if (it != null) {
                binding.apply {
                    gitName.text = it.name
                    gitUsername.text = it.login

                    Glide.with(this@DetailUserActivity)
                        .load(it.avatar_url)
                        .into(gambarProfile)
                }
            }
        })

        val sectionPagerAdapter = SectionPagerAdaptor(this, supportFragmentManager, bundle)
        binding.apply {
            viewPager.adapter = sectionPagerAdapter
            tabs.setupWithViewPager(viewPager)
        }

    }
}