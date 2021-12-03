package com.example.appretomovil;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Clase Fragment Producto
 * (Antigua Activity)
 *
 * @version 1.1
 * @author Jhoan Villa G35 C4
 */
public class ProductoFragment extends Fragment {

    /**
     * Método onCreate: constructor de la pantalla o vista asociada
     *
     * @param inflater datos del layout
     * @param container contenedor vinculado
     * @param savedInstState instancia del fragmento en la ejecución
     * @return vista generada
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstState) {

        /**
         * Se carga los botones e imágenes en la pantalla
         */

        /**
         * Variable que representa la vista del contendor del fragmento
         */
        View view = inflater.inflate(R.layout.fragment_producto, container, false);

        /**
         * Variables que representan lo botones del producto 1
         */
        ImageButton ibtChaqueta1 = (ImageButton) view.findViewById(R.id.imbProducto1);
        ImageButton ibtFavChaq1 = (ImageButton) view.findViewById(R.id.imbFavProducto1);
        ImageButton ibtCarChaq1 = (ImageButton) view.findViewById(R.id.imbCarProducto1);

        /**
         * Variables que representan lo botones del producto 2
         */
        ImageButton ibtChaqueta2 = (ImageButton) view.findViewById(R.id.imbProducto2);
        ImageButton ibtFavChaq2 = (ImageButton) view.findViewById(R.id.imbFavProducto2);
        ImageButton ibtCarChaq2 = (ImageButton) view.findViewById(R.id.imbCarProducto2);

        /**
         * Variables que representan lo botones del producto 3
         */
        ImageButton ibtChaqueta3 = (ImageButton) view.findViewById(R.id.imbProducto3);
        ImageButton ibtFavChaq3 = (ImageButton) view.findViewById(R.id.imbFavProducto3);
        ImageButton ibtCarChaq3 = (ImageButton) view.findViewById(R.id.imbCarProducto3);

        /**
         * Variables que representan lo botones del producto 4
         */
        ImageButton ibtChaqueta4 = (ImageButton) view.findViewById(R.id.imbProducto4);
        ImageButton ibtFavChaq4 = (ImageButton) view.findViewById(R.id.imbFavProducto4);
        ImageButton ibtCarChaq4 = (ImageButton) view.findViewById(R.id.imbCarProducto4);

        /**
         * Variables que representan lo botones del producto 5
         */
        ImageButton ibtChaqueta5 = (ImageButton) view.findViewById(R.id.imbProducto5);
        ImageButton ibtFavChaq5 = (ImageButton) view.findViewById(R.id.imbFavProducto5);
        ImageButton ibtCarChaq5 = (ImageButton) view.findViewById(R.id.imbCarProducto5);

        /**
         * Variables que representan lo botones del producto 6
         */
        ImageButton ibtChaqueta6 = (ImageButton) view.findViewById(R.id.imbProducto6);
        ImageButton ibtFavChaq6 = (ImageButton) view.findViewById(R.id.imbFavProducto6);
        ImageButton ibtCarChaq6 = (ImageButton) view.findViewById(R.id.imbCarProducto6);

        /**
         * Variables que representan las imágenes
         */

        /**
         * Variable que representa la imagen de chaqueta 1
         */
        Drawable drawable1;

        /**
         * Variable que representa la imagen de chaqueta 2
         */
        Drawable drawable2;

        /**
         * Variable que representa la imagen de chaqueta 3
         */
        Drawable drawable3;

        /**
         * Variable que representa la imagen para añadir favortio
         */
        Drawable drawableF1;

        /**
         * Variable que representa la imagen de carro de compra agregar
         */
        Drawable drawableC1;

        /**
         * Variables que representan los estados de los botones favoritos y carro
         */
        final boolean[] fav = {false, false, false, false, false, false};
        final boolean[] car = {false, false, false, false, false, false};

        /**
         * Ingreso de imágenes en los ImageButton
         */
        Resources resFav1 = getResources();
        drawableF1 = resFav1.getDrawable(R.drawable.ic_baseline_favorite_border_24);
        ibtFavChaq1.setImageDrawable(drawableF1);
        ibtFavChaq2.setImageDrawable(drawableF1);
        ibtFavChaq3.setImageDrawable(drawableF1);
        ibtFavChaq4.setImageDrawable(drawableF1);
        ibtFavChaq5.setImageDrawable(drawableF1);
        ibtFavChaq6.setImageDrawable(drawableF1);

        Resources resCar1 = getResources();
        drawableC1 = resCar1.getDrawable(R.drawable.ic_baseline_add_shopping_cart_24);
        ibtCarChaq1.setImageDrawable(drawableC1);
        ibtCarChaq2.setImageDrawable(drawableC1);
        ibtCarChaq3.setImageDrawable(drawableC1);
        ibtCarChaq4.setImageDrawable(drawableC1);
        ibtCarChaq5.setImageDrawable(drawableC1);
        ibtCarChaq6.setImageDrawable(drawableC1);

        Resources res1 = getResources();
        drawable1 = res1.getDrawable(R.drawable.chq1);
        ibtChaqueta1.setImageDrawable(drawable1);

        Resources res2 = getResources();
        drawable2 = res2.getDrawable(R.drawable.chq2);
        ibtChaqueta2.setImageDrawable(drawable2);

        Resources res3 = getResources();
        drawable3 = res3.getDrawable(R.drawable.chq3);
        ibtChaqueta3.setImageDrawable(drawable3);

        ibtChaqueta4.setImageDrawable(drawable1);

        ibtChaqueta5.setImageDrawable(drawable2);

        ibtChaqueta6.setImageDrawable(drawable3);

        /**
         * Implementación y configuración de listeners onClick
         */
        ibtChaqueta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Se seleciona la chaqueta 1",
                        Toast.LENGTH_SHORT).show();
            }
        });
        ibtChaqueta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Se seleciona la chaqueta 2",
                        Toast.LENGTH_SHORT).show();
            }
        });
        ibtChaqueta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Se seleciona la chaqueta 3",
                        Toast.LENGTH_SHORT).show();
            }
        });
        ibtChaqueta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Se seleciona la chaqueta 4",
                        Toast.LENGTH_SHORT).show();
            }
        });
        ibtChaqueta5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Se seleciona la chaqueta 5",
                        Toast.LENGTH_SHORT).show();
            }
        });
        ibtChaqueta6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Se seleciona la chaqueta 6",
                        Toast.LENGTH_SHORT).show();
            }
        });
        ibtFavChaq1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fav[0]) {
                    Toast.makeText(getContext(), "La chaqueta 1 se quitó de tus favoritos",
                            Toast.LENGTH_SHORT).show();
                    fav[0] = false;
                    ibtFavChaq1.setImageDrawable(drawableF1);
                } else {
                    Resources resFav2 = getResources();
                    Drawable drawableF2 = resFav2.getDrawable(R.drawable.ic_baseline_favorite_24);
                    Toast.makeText(getContext(), "La chaqueta 1 se agregó a tus favoritos",
                        Toast.LENGTH_SHORT).show();
                    fav[0] = true;
                    ibtFavChaq1.setImageDrawable(drawableF2);
                }
            }
        });
        ibtCarChaq1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (car[0]) {
                    Toast.makeText(getContext(), "La chaqueta 1 se quitó del carro de compras",
                            Toast.LENGTH_SHORT).show();
                    car[0] = false;
                    ibtCarChaq1.setImageDrawable(drawableC1);
                } else {
                    Resources resCar2 = getResources();
                    Drawable drawableC2 = resCar2.getDrawable(R.drawable
                            .ic_baseline_remove_shopping_cart_24);
                    Toast.makeText(getContext(), "La chaqueta 1 se agregó al carro de compras",
                            Toast.LENGTH_SHORT).show();
                    car[0] = true;
                    ibtCarChaq1.setImageDrawable(drawableC2);
                }
            }
        });
        ibtFavChaq2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fav[1]) {
                    Toast.makeText(getContext(), "La chaqueta 2 se quitó de tus favoritos",
                            Toast.LENGTH_SHORT).show();
                    fav[1] = false;
                    ibtFavChaq2.setImageDrawable(drawableF1);
                } else {
                    Resources resFav2 = getResources();
                    Drawable drawableF2 = resFav2.getDrawable(R.drawable.ic_baseline_favorite_24);
                    Toast.makeText(getContext(), "La chaqueta 2 se agregó a tus favoritos",
                            Toast.LENGTH_SHORT).show();
                    fav[1] = true;
                    ibtFavChaq2.setImageDrawable(drawableF2);
                }
            }
        });
        ibtCarChaq2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (car[1]) {
                    Toast.makeText(getContext(), "La chaqueta 2 se quitó del carro de compras",
                            Toast.LENGTH_SHORT).show();
                    car[1] = false;
                    ibtCarChaq2.setImageDrawable(drawableC1);
                } else {
                    Resources resCar2 = getResources();
                    Drawable drawableC2 = resCar2.getDrawable(R.drawable
                            .ic_baseline_remove_shopping_cart_24);
                    Toast.makeText(getContext(), "La chaqueta 2 se agregó al carro de compras",
                            Toast.LENGTH_SHORT).show();
                    car[1] = true;
                    ibtCarChaq2.setImageDrawable(drawableC2);
                }
            }
        });
        ibtFavChaq3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fav[2]) {
                    Toast.makeText(getContext(), "La chaqueta 3 se quitó de tus favoritos",
                            Toast.LENGTH_SHORT).show();
                    fav[2] = false;
                    ibtFavChaq3.setImageDrawable(drawableF1);
                } else {
                    Resources resFav2 = getResources();
                    Drawable drawableF2 = resFav2.getDrawable(R.drawable.ic_baseline_favorite_24);
                    Toast.makeText(getContext(), "La chaqueta 3 se agregó a tus favoritos",
                            Toast.LENGTH_SHORT).show();
                    fav[2] = true;
                    ibtFavChaq3.setImageDrawable(drawableF2);
                }
            }
        });
        ibtCarChaq3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (car[2]) {
                    Toast.makeText(getContext(), "La chaqueta 3 se quitó del carro de compras",
                            Toast.LENGTH_SHORT).show();
                    car[2] = false;
                    ibtCarChaq3.setImageDrawable(drawableC1);
                } else {
                    Resources resCar2 = getResources();
                    Drawable drawableC2 = resCar2.getDrawable(R.drawable
                            .ic_baseline_remove_shopping_cart_24);
                    Toast.makeText(getContext(), "La chaqueta 3 se agregó al carro de compras",
                            Toast.LENGTH_SHORT).show();
                    car[2] = true;
                    ibtCarChaq3.setImageDrawable(drawableC2);
                }
            }
        });
        ibtFavChaq4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fav[3]) {
                    Toast.makeText(getContext(), "La chaqueta 4 se quitó de tus favoritos",
                            Toast.LENGTH_SHORT).show();
                    fav[3] = false;
                    ibtFavChaq4.setImageDrawable(drawableF1);
                } else {
                    Resources resFav2 = getResources();
                    Drawable drawableF2 = resFav2.getDrawable(R.drawable.ic_baseline_favorite_24);
                    Toast.makeText(getContext(), "La chaqueta 4 se agregó a tus favoritos",
                            Toast.LENGTH_SHORT).show();
                    fav[3] = true;
                    ibtFavChaq4.setImageDrawable(drawableF2);
                }
            }
        });
        ibtCarChaq4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (car[3]) {
                    Toast.makeText(getContext(), "La chaqueta 4 se quitó del carro de compras",
                            Toast.LENGTH_SHORT).show();
                    car[3] = false;
                    ibtCarChaq4.setImageDrawable(drawableC1);
                } else {
                    Resources resCar2 = getResources();
                    Drawable drawableC2 = resCar2.getDrawable(R.drawable
                            .ic_baseline_remove_shopping_cart_24);
                    Toast.makeText(getContext(), "La chaqueta 4 se agregó al carro de compras",
                            Toast.LENGTH_SHORT).show();
                    car[3] = true;
                    ibtCarChaq4.setImageDrawable(drawableC2);
                }
            }
        });
        ibtFavChaq5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fav[4]) {
                    Toast.makeText(getContext(), "La chaqueta 5 se quitó de tus favoritos",
                            Toast.LENGTH_SHORT).show();
                    fav[4] = false;
                    ibtFavChaq5.setImageDrawable(drawableF1);
                } else {
                    Resources resFav2 = getResources();
                    Drawable drawableF2 = resFav2.getDrawable(R.drawable.ic_baseline_favorite_24);
                    Toast.makeText(getContext(), "La chaqueta 5 se agregó a tus favoritos",
                            Toast.LENGTH_SHORT).show();
                    fav[4] = true;
                    ibtFavChaq5.setImageDrawable(drawableF2);
                }
            }
        });
        ibtCarChaq5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (car[4]) {
                    Toast.makeText(getContext(), "La chaqueta 5 se quitó del carro de compras",
                            Toast.LENGTH_SHORT).show();
                    car[4] = false;
                    ibtCarChaq5.setImageDrawable(drawableC1);
                } else {
                    Resources resCar2 = getResources();
                    Drawable drawableC2 = resCar2.getDrawable(R.drawable
                            .ic_baseline_remove_shopping_cart_24);
                    Toast.makeText(getContext(), "La chaqueta 5 se agregó al carro de compras",
                            Toast.LENGTH_SHORT).show();
                    car[4] = true;
                    ibtCarChaq5.setImageDrawable(drawableC2);
                }
            }
        });
        ibtFavChaq6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fav[5]) {
                    Toast.makeText(getContext(), "La chaqueta 6 se quitó de tus favoritos",
                            Toast.LENGTH_SHORT).show();
                    fav[5] = false;
                    ibtFavChaq6.setImageDrawable(drawableF1);
                } else {
                    Resources resFav2 = getResources();
                    Drawable drawableF2 = resFav2.getDrawable(R.drawable.ic_baseline_favorite_24);
                    Toast.makeText(getContext(), "La chaqueta 6 se agregó a tus favoritos",
                            Toast.LENGTH_SHORT).show();
                    fav[5] = true;
                    ibtFavChaq6.setImageDrawable(drawableF2);
                }
            }
        });
        ibtCarChaq6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (car[5]) {
                    Toast.makeText(getContext(), "La chaqueta 6 se quitó del carro de compras",
                            Toast.LENGTH_SHORT).show();
                    car[5] = false;
                    ibtCarChaq6.setImageDrawable(drawableC1);
                } else {
                    Resources resCar2 = getResources();
                    Drawable drawableC2 = resCar2.getDrawable(R.drawable
                            .ic_baseline_remove_shopping_cart_24);
                    Toast.makeText(getContext(), "La chaqueta 6 se agregó al carro de compras",
                            Toast.LENGTH_SHORT).show();
                    car[5] = true;
                    ibtCarChaq6.setImageDrawable(drawableC2);
                }
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}