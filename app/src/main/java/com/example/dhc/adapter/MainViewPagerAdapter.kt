import android.content.Context
import android.util.SparseArray
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.dhc.R
import com.example.dhc.fragment.BuyRootFragment
import com.example.dhc.fragment.HomeRootFragment
import com.example.dhc.fragment.SettingsRootFragment


class MainViewPagerAdapter(fm: FragmentManager, private val context: Context): FragmentPagerAdapter(fm){

    var registeredFragments = SparseArray<Fragment>()

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> {
                HomeRootFragment()
            }
            1 -> {
                BuyRootFragment()
            }
            else ->  {
                SettingsRootFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> {
                this.context.getString(R.string.home_title)
            }
            1 -> {
                this.context.getString(R.string.buy_title)
            }
            else ->  {
                this.context.getString(R.string.setting_title)
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val fragment = super.instantiateItem(container, position) as Fragment
        registeredFragments.put(position, fragment)
        return fragment
    }

    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, view)
    }

    fun getRegisteredFragment(position: Int): Fragment {
        return registeredFragments.get(position);
    }
}