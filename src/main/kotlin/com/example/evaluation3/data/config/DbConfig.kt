package com.example.evaluation3.data.config

import com.example.evaluation3.data.config.DbConfig.shutdown
import com.example.evaluation3.data.model.entities.Animal
import com.example.evaluation3.data.model.entities.Specie
import com.example.evaluation3.data.model.entities.SubSpecie
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

object DbConfig {
    private const val dbName = "av2"
    private const val user = "root"
    private const val password = "gremio10"

    private val sessionFactory: SessionFactory = buildSessionFactory()
    var session: Session = sessionFactory.openSession()
        get() {
            if (!field.isOpen) {
                field = sessionFactory.openSession()
            }
            return field
        }

    private fun buildSessionFactory(): SessionFactory {
        return try {
            Configuration()
                .setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                .setProperty(
                    "hibernate.connection.url",
                    "jdbc:mysql://localhost/$dbName?autoReconnect=true&useSSL=false"
                )
                .setProperty("hibernate.connection.username", user)
                .setProperty("hibernate.connection.password", password)
                .setProperty("hibernate.jdbc.time_zone", "UTC")
                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.format_sql", "false")
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .setProperty("hibernate.connection.autocommit", "true")
                .addAnnotatedClass(Specie::class.java)
                .addAnnotatedClass(SubSpecie::class.java)
                .addAnnotatedClass(Animal::class.java)
                .buildSessionFactory()
        } catch (e: Throwable) {
            e.printStackTrace()
            throw ExceptionInInitializerError(e)
        }
    }

    fun Session.shutdown() {
        close()
    }
}

//private fun main() {
//    DbConfig.session.run {
//        beginTransaction()
//        save(Specie(
//            name = "Monkey",
//            diet = Diet.HERBIVORE,
//            movements = setOf(Movement.WALK)
//        ))
//        transaction.commit()
//
//        val monkey = find(Specie::class.java, 1L)
//
//        println(monkey.name)
//        println(monkey.diet.description)
//        println(monkey.movements)
//
//        shutdown()
//    }
//}