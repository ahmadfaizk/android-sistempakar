package com.faiz.sistempakar.helpers

import com.faiz.sistempakar.model.Disease
import com.faiz.sistempakar.model.Infection
import com.faiz.sistempakar.model.Question

object DataHelper {

    fun getListQuestion(): ArrayList<Question> {
        val listQuestion = ArrayList<Question>()
        listQuestion.add(Question("Buang air besar (lebih dari 2 kali)"))
        listQuestion.add(Question("Berak encer"))
        listQuestion.add(Question("Berak beradarah"))
        listQuestion.add(Question("Lesu dan tidak bergairah"))
        listQuestion.add(Question("Tidak selera makan"))
        listQuestion.add(Question("Merasa mual dan sering muntah (lebih dari 1 kali)"))
        listQuestion.add(Question("Merasa sakit di bagian perut"))
        listQuestion.add(Question("Tekanan darah rendah"))
        listQuestion.add(Question("Pusing"))
        listQuestion.add(Question("Pingsan"))
        listQuestion.add(Question("Suhu badan tinggi"))
        listQuestion.add(Question("Luka di bagian tertentu"))
        listQuestion.add(Question("Tidak dapat menggerakkan anggota badan tertentu"))
        listQuestion.add(Question("Memakan sesuatu"))
        listQuestion.add(Question("Memakan daging"))
        listQuestion.add(Question("Memakan jamur"))
        listQuestion.add(Question("Memakan makanan kaleng"))
        listQuestion.add(Question("Membeli susu"))
        listQuestion.add(Question("Memingun susu"))
        return listQuestion
    }

    private fun getListDisease(): ArrayList<Disease> {
        val listDisease = ArrayList<Disease>()
        listDisease.add(Disease("Mencret", listOf(1, 2, 4, 5)))
        listDisease.add(Disease("Muntah", listOf(4, 5, 6)))
        listDisease.add(Disease("Sakit Perut", listOf(4, 7)))
        listDisease.add(Disease("Darah Rendah", listOf(4, 8 , 9)))
        listDisease.add(Disease("Koma", listOf(8, 10)))
        listDisease.add(Disease("Demam", listOf(4, 5, 9, 11)))
        listDisease.add(Disease("Septicaemia", listOf(4, 8, 11, 12)))
        listDisease.add(Disease("Lumpuh", listOf(4, 13)))
        listDisease.add(Disease("Mencret Berdarah", listOf(1, 2, 3, 4, 5)))
        listDisease.add(Disease("Makan Daging", listOf(14, 15)))
        listDisease.add(Disease("Makan Jamur", listOf(14, 16)))
        listDisease.add(Disease("Makan Makanan Kaleng", listOf(14, 17)))
        listDisease.add(Disease("Minum Susu", listOf(18, 19)))
        return listDisease
    }

    fun getListInfection(): ArrayList<Infection> {
        val listCategory = ArrayList<Infection>()
        val listDisease = getListDisease()

        listCategory.add(Infection("Keracunan Staphylococcus aureus", listOf(
            listDisease[0],
            listDisease[1],
            listDisease[2],
            listDisease[3],
            listDisease[9]
        )))

        listCategory.add(Infection("Keracunan jamur beracun", listOf(
            listDisease[0],
            listDisease[1],
            listDisease[2],
            listDisease[4],
            listDisease[10]
        )))

        listCategory.add(Infection("Keracunan Salmonellae", listOf(
            listDisease[0],
            listDisease[1],
            listDisease[2],
            listDisease[5],
            listDisease[6],
            listDisease[9]
        )))

        listCategory.add(Infection("Keracunan Clostridium botulinum", listOf(
            listDisease[1],
            listDisease[7],
            listDisease[11]
        )))

        listCategory.add(Infection("Keracunan Campylobacter", listOf(
            listDisease[8],
            listDisease[2],
            listDisease[5],
            listDisease[12]
        )))

        return listCategory
    }
}