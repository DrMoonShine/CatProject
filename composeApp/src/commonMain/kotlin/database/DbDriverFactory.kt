package database



import app.cash.sqldelight.db.SqlDriver



expect class DbDriverFactory {
    fun createDriver(): SqlDriver
}