package es.pinf.ucare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.os.Bundle;

public class LandingPage extends FragmentActivity
{
    private static final int nFragments = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        // Instantiate a ViewPager and a PagerAdapter.
        ViewPager2 mPager = findViewById(R.id.landingPageSlider);
        ScreenSlidePagerAdapter pagerAdapter = new ScreenSlidePagerAdapter(this);
        mPager.setAdapter(pagerAdapter);

    }

    private static class ScreenSlidePagerAdapter extends FragmentStateAdapter
    {

        public ScreenSlidePagerAdapter(FragmentActivity fa)
        {
            super(fa);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position)
        {
            Fragment finalFragment;

            switch (position)
            {
                case 1:
                    finalFragment = new LandingFragmentSecond();
                    break;
                case 2:
                    finalFragment = new LandingPageThree();
                    break;
                default:
                    finalFragment = new LandingFragmentFirst();
                    break;
            }

            return finalFragment;
        }

        @Override
        public int getItemCount()
        {
            return nFragments;
        }
    }
}