package com.ismin.android

import java.lang.RuntimeException

class WomenList {

    private val women: HashMap<String, Woman> = HashMap();

    fun addWoman(woman: Woman) {
        women[woman.name] = woman;
    }

    fun getWoman(name: String): Woman {
        return women[name] ?: throw RuntimeException("No woman with name: $name");
    }

    fun getAllWomen(): ArrayList<Woman> {
        return ArrayList(women.values.sortedBy { it.name })
    }

    fun getDescriptionOf(name: String): List<Woman> {
        return women.filterValues { it.name.equals(name, ignoreCase = true) }
            .values
            .sortedBy { it.name }
            .toList();
    }

    fun getTotalNumberOfWomen(): Int {
        return women.size;
    }

    fun clean() {
        women.clear();
    }


}