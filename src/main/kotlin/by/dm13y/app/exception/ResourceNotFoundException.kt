package by.dm13y.app.exception

class ResourceNotFoundException: BusinessException {
    constructor()

    constructor(message: String) : super(message)
}