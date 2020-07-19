package husaynhakeem.io.mvvm.model

data class Cell(var player: Player?) {

    val isEmpty: Boolean
        get() = player == null
}
