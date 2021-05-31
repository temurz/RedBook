package com.texnopos.redbook.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.texnopos.redbook.R
import com.texnopos.redbook.data.RedBookDatabase
import com.texnopos.redbook.data.dao.AnimalDao
import com.texnopos.redbook.data.model.Animal
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_animal.view.*

class DetailActivity : AppCompatActivity() {
    companion object{
        const val ANIMAL_ID = "animalId"
    }

    private var animalId: Int = 0
    private lateinit var currentAnimal: Animal
    private lateinit var dao : AnimalDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Details")


        dao = RedBookDatabase.getInstance(this).dao()
        animalId = intent.getIntExtra(ANIMAL_ID,0)
        currentAnimal = dao.getAnimalById(animalId)
        tvStatusContent.text = currentAnimal.status
        tvBreedingContent.text = currentAnimal.breeding
        tvHabitatContent.text = currentAnimal.habitat
        tvLifestyleContent.text = currentAnimal.lifestyle
        tvLimitingFactorsContent.text = currentAnimal.limitingfactors
        tvPropagationContent.text = currentAnimal.propagation
        tvQuantityContent.text = currentAnimal.quantity
        tvSecurityContent.text = currentAnimal.security

        Glide
            .with(this)
            .load(resources.getIdentifier("picture${animalId}", "drawable", packageName))
            .into(ivDetail)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}