package com.simulacratech.scora

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.simulacratech.scora.base.ConfigToolbar
import com.simulacratech.scora.core.setupWithNavController
import com.simulacratech.scora.databinding.ActivityMainBinding
import com.simulacratech.scora.utils.Constants.Companion.BACK_ICON
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(){
    val TAG: String
        get() = this.javaClass.name
    private val viewModel:MainActivityViewModel by viewModels()

    private var currentNavController: LiveData<NavController>? = null

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        setSupportActionBar(binding.toolbar)

        navController = findNavController(R.id.nav_host_fragment_content_main)

        navController.addOnDestinationChangedListener(destinationChangedListener)

        lifecycleScope.launchWhenStarted {
            viewModel.changeNavGraphEventFlow.collect {
                when(it){
                    R.navigation.nav_auth -> {
                        navController.setGraph(R.navigation.nav_auth)
                        viewModel.menuNavHostVisibility.postValue(View.VISIBLE)
                        viewModel.bottomNavHostVisibility.postValue(View.GONE)
                        viewModel.bottomNavVisibility.postValue(View.GONE)
                    }
                    else -> {
                        navController.setGraph(it)
                        viewModel.menuNavHostVisibility.postValue(View.GONE)
                        viewModel.bottomNavHostVisibility.postValue(View.VISIBLE)
                        viewModel.bottomNavVisibility.postValue(View.VISIBLE)
                        setupBottomNavigationBar()
                    }
                }
                appBarConfiguration = AppBarConfiguration(navController.graph)
                setupActionBarWithNavController(navController, appBarConfiguration)
            }
        }

        viewModel.changeNavGraph(R.navigation.nav_auth)

    }

    val destinationChangedListener =
        NavController.OnDestinationChangedListener { controller, destination, arguments ->
            binding.toolbar.visibility = View.VISIBLE
            viewModel.toolbarTitle(ConfigToolbar("", BACK_ICON))
        }


    private fun setupBottomNavigationBar() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav)

        val navGraphIds = listOf(
            R.navigation.nav_feed,
            R.navigation.nav_sports_selection,
            R.navigation.nav_booking,
            R.navigation.nav_user_rewards)

        // Setup the bottom navigation view with a list of navigation graphs
        val controller = bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_container,
            intent = intent
        )

        // Whenever the selected controller changes, setup the action bar.
        controller.observe(this) { navController ->
            setupActionBarWithNavController(navController)
            navController.removeOnDestinationChangedListener(bottomDestinationChangedListener)
            navController.addOnDestinationChangedListener(bottomDestinationChangedListener)
        }

        currentNavController = controller

    }

    private val bottomDestinationChangedListener =
        NavController.OnDestinationChangedListener { controller, destination, arguments ->
            viewModel.destinationLabel = destination.label
            /*if(destination.label == getString(R.string.menu_home)){
                viewModel.toolbarTitle(ConfigToolbar(""))
            }else if((destination.label == getString(R.string.menu_categories)
                        ||
                        destination.label == getString(R.string.menu_products)
                        ||
                        destination.label == getString(R.string.menu_wishlist)
                        ||
                        destination.label == getString(R.string.menu_deals))
            ){
                destination.label?.let {
                    viewModel.toolbarTitle(ConfigToolbar(it.toString()))
                }
            }else{
                destination.label?.let {
                    viewModel.toolbarTitle(ConfigToolbar(it.toString(), BACK_ICON))
                }
            }*/
        }
}