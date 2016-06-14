package com.example.billy.spaceapp.Communicate;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.billy.spaceapp.Learn.Fragment.PlanetFragment;
import com.example.billy.spaceapp.R;

/**
 * Created by Raiders on 6/14/16.
 */
public class CommunicatePageAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    Context context;

    public CommunicatePageAdapter(FragmentManager fm, int mNumOfTabs) {
        super(fm);
        this.mNumOfTabs = mNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                PlanetFragment tab1Mercury = new PlanetFragment();
                tab1Mercury.setPlanetName("Mercury");
                tab1Mercury.setPlanetDetails("The planet Mercury is the closest of the planets to the Sun. Because this planet lies so close to the Sun, and as a result somewhat near to Earth, it is visible to observers on Earth in the late evening or early morning sky. Because of this, Mercury has become a part of the mythology and legend of almost every culture throughout the history of the Earth.\n\n" +
                        "This planet is often called a morning star. This is because Mercury shines brightly in the early morning just before the sun rises. It has also been called an evening star for the same reason. Mercury is often visible for a brief period of time just after the Sun sets.");
//                Picasso.with(context).load().placeholder(R.drawable.default_solarsystem).error(R.drawable.default_solarsystem).into();
                tab1Mercury.setPlanetImageResource(R.drawable.mercury1);
                return tab1Mercury;
            case 1:
                PlanetFragment tab2Venus = new PlanetFragment();
                tab2Venus.setPlanetName("Venus");
                tab2Venus.setPlanetDetails("The planet Venus has long been one of the most misunderstood of all the inner planets. Like the Earth, Venus has an atmosphere. However, Venus' atmosphere is far thicker than that of the Earth, making it difficult for modern science to penetrate. Interestingly, scientists have recently been able to peek through the thick clouds and get a few glimpses of the surface. There are numerous volcanoes and many mountains that appear misshapen.\n" +
                        "\n" +
                        "There is much we still do not know about how this planet looks and what it is like. However, using special instruments and probes scientists have in recent years unlocked many of the secrets long hidden by this mysterious world. In the 1970s, the Soviet Union actually was able to land more than one probe on the surface of Venus. These scientific probes only lasted a few hours before they were destroyed by the intense heat of the planet. These probes were able to take several pictures and send them back to earth for scientists to study.");
                tab2Venus.setPlanetImageResource(R.drawable.venus2);
                return tab2Venus;
            case 2:
                PlanetFragment tab3Earth = new PlanetFragment();
                tab3Earth.setPlanetName("Earth");
                tab3Earth.setPlanetDetails("The Earth is the biggest of all the terrestrial planets. A terrestrial planet is a dense planet found in the inner Solar System. The diameter of Earth is 7,926 miles. The circumference measured around the equator is 24,901 miles. There are currently almost 7 billion people living on the Earth. About 30% of the Earth's surface is covered with land, while about 70% is covered by oceans.\n\n" +
                        "Our planet is  an oasis of life in an otherwise desolate universe.  The Earth's temperature, weather, atmosphere and many other factors are just right to keep us alive.");
                tab3Earth.setPlanetImageResource(R.drawable.earth3);
                return tab3Earth;
            case 3:
                PlanetFragment tab4Mars = new PlanetFragment();
                tab4Mars.setPlanetName("Mars");
                tab4Mars.setPlanetDetails("Mars excites scientists because its mild temperament is more like the Earth's than any of the other planets. Evidence suggests that Mars once had rivers, streams, lakes, and even an ocean. As Mars' atmosphere slowly depleted into outer space, the surface water began to permanently evaporate. Today the only water on Mars in either frozen in the polar caps or underground.\n" +
                        "\n" +
                        "You may sometimes hear Mars referred to as the \"Red Planet.\" This is because the surface of Mars is red. If you stood on the surface of Mars, you would see red dirt and rocks everywhere.");
                tab4Mars.setPlanetImageResource(R.drawable.mars4);
                return tab4Mars;
            case 4:
                PlanetFragment tab5Jupiter = new PlanetFragment();
                tab5Jupiter.setPlanetName("Jupiter");
                tab5Jupiter.setPlanetDetails("Jupiter is by far the largest planet in our Solar System. The Earth could fit inside Jupiter more than 1000 times.\n\n" +
                        "Jupiter is a very stormy planet. There are storms found throughout the atmosphere, and most of the storms seem to never end. The many different cloud formations and storms in the atmosphere also make Jupiter a very colorful planet.\n" +
                        "\n" +
                        "Jupiter's great red spot, visible in the picture above to the right, is where a giant storm has been raging for at least 300 years. This red spot is also called \"The Eye of Jupiter\" because of its shape. This storm's super hurricane winds blow across an area larger than the Earth.\n" +
                        "\n" +
                        "Jupiter is considered a gas giant because it does not have a solid surface. Under its atmosphere is a large liquid ocean of hydrogen and water. What lies in between that ocean and the atmosphere? Actually, there is no in between. The atmosphere slowly gets thicker and thicker until it becomes part of the ocean. In other words, Jupiter's ocean has no surface on which you could float a boat. The sky becomes the ocean.");
                tab5Jupiter.setPlanetImageResource(R.drawable.jupiter5);
                return tab5Jupiter;
            case 5:
                PlanetFragment tab6Saturn = new PlanetFragment();
                tab6Saturn.setPlanetName("Saturn");
                tab6Saturn.setPlanetDetails("In many ways, Saturn is similar to Jupiter, but it is much smaller. It is the second largest planet in our Solar System and it is a gas giant like Jupiter. Under the clouds of methane, hydrogen and helium, the sky gradually turns into liquid until it becomes a giant ocean of liquid chemicals.\n\n" +
                        "Saturn is the least dense planet in our Solar System. It is made up of mostly hydrogen and helium, which are the two lightest elements in the universe and thus make Saturn the lightest planet that we know of. This is why you wouldn't weigh as much on Saturn as you think you would because of its size. And because Saturn is so light, it does not have as much gravity. Interestingly, it is believed Saturn would actually be able to float in water because the hydrogen and helium that make up the planet are so lightweight.\n" +
                        "\n" +
                        "Because Saturn is such a lightweight planet and it spins so fast, Saturn is not perfectly round like most of the other planets. Like Jupiter, Saturn is wider in the middle and more narrow near its top and bottom.");
                tab6Saturn.setPlanetImageResource(R.drawable.saturn6);
                return tab6Saturn;
            case 6:
                PlanetFragment tab7Uranus = new PlanetFragment();
                tab7Uranus.setPlanetName("Uranus");
                tab7Uranus.setPlanetDetails("Like Jupiter and Saturn, Uranus is a gas giant. But Uranus is a little different. Unlike all the other planets and most of the moons in our Solar System, Uranus spins on its side. It is believed that long ago a very large object smashed into this planet. The crash was so powerful that it completely changed the direction of Uranus' planetary rotation. However, a more recent theory is that the extreme tilt of Uranus' axis may have been caused by a large moon that was slowly pulled away from the planet by another large planet long ago when our Solar System was still new. It is thought that the gravitational pull of this moon moving away from Uranus may have caused it to tilt on its side.\n\n" +
                        "Like Saturn, the thick atmosphere of Uranus is made up of methane, hydrogen and helium. But Uranus is an extremely cold planet. It has been called the \"ice giant.\" It is believed that Uranus is made up of rock and ice and has a large rocky core. Because of the tremendous planetary pressure of Uranus, there could possibly be trillions of large diamonds in or on the surface of this planet.\n" +
                        "\n" +
                        "Scientists also believe that on the surface of Uranus there may be a huge ocean. And, interestingly, it is thought that the temperature of this ocean may be extremely hot, maybe even as hot as 5000 degrees Fahrenheit (2760 Celsius).\n" +
                        "\n" +
                        "Uranus is almost identical to the planet Neptune.");
                tab7Uranus.setPlanetImageResource(R.drawable.uranus7);
                return tab7Uranus;
            case 7:
                PlanetFragment tab8Neptune = new PlanetFragment();
                tab8Neptune.setPlanetName("Neptune");
                tab8Neptune.setPlanetDetails("For many, centuries people did not know that this planet even existed. It was discovered by Johann Galle and Heinrich D'Arrest in 1846.\n" +
                        "Neptune is the smallest of the four gas giants in our Solar System. Much like Saturn and Uranus, Neptune's atmosphere contains hydrogen, helium and methane.\n" +
                        "\n" +
                        "Not much was known about Neptune until it was visited by the spacecraft Voyager 2 on August 25, 1989. Voyager 2 took many pictures of the planet, and much of what we know today about Neptune came from this single visit. These pictures show a brilliant blue planet with a few thin white clouds laced around its surface.\n" +
                        "\n" +
                        "In Neptune's atmosphere, there is a large white cloud that moves around rather quickly. The \"scooting\" of this cloud around the atmosphere has led it to be named \"Scooter.\"\n" +
                        "\n" +
                        "When Voyager 2 visited Neptune, its pictures showed a giant storm much like the storm on Jupiter. This storm is called the \"Great Dark Spot\" because it appears as a dark oval shape on the surface of the planet. We do not know how long this storm has been active or if it is still present. More recently, the Hubble Space Telescope sent pictures back to Earth and there was no sign of the Great Dark Spot. These pictures did show two other dark spots that eventually faded away.\n" +
                        "\n" +
                        "Neptune is a very windy place. No other planet in the Solar System has winds that are as strong as Neptune's. The winds near the Great Dark Spot were believed to have reached nearly 1,200 miles per hour (approx 1931 km per hour). Perhaps this extremely windy atmosphere contributes to the appearance and disappearance of the great dark spots.");
                tab8Neptune.setPlanetImageResource(R.drawable.neptune8);
                return tab8Neptune;
        }

        return null;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
