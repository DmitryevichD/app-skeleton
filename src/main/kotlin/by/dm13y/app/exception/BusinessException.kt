package by.dm13y.app.exception

abstract class BusinessException : RuntimeException {
    constructor() : super()

    constructor(message: String) : super(message)
}