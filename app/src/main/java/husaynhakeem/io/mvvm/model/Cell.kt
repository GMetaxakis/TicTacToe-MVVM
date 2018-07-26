package husaynhakeem.io.mvvm.model

class Cell(var player: Player?) {
    val isEmpty: Boolean
        get() = player == null || player?.value.isNullOrEmpty()
}
