package uship.auth.authmicro.model.routes

enum class WarehouseRoutes (val uri: String, val roles: Array<Roles>) {

    CREATE("ADD ENDPOINT", arrayOf(Roles.ADMIN, Roles.SUPPLIER)),
    READ("ADD ENDPOINT", arrayOf(Roles.ADMIN, Roles.SUPPLIER)),
    UPDATE("ADD ENDPOINT", arrayOf(Roles.ADMIN, Roles.SUPPLIER)),
    DELETE("ADD ENDPOINT", arrayOf(Roles.ADMIN, Roles.SUPPLIER))

}