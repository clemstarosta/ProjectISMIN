import android.os.Bundle
import androidx.fragment.app.Fragment


/**
 * Fragment that displays information about the app.
 */
class MapFragment : Fragment() {
    companion object {
        @JvmStatic
        fun newInstance() =
            MapFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}