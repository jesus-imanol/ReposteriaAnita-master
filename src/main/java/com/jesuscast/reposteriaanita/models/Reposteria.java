package com.jesuscast.reposteriaanita.models;

import com.jesuscast.reposteriaanita.AppReposteria;

import java.util.ArrayList;

public class Reposteria {
        private ArrayList<Pedido> listaPedidos = new ArrayList<>();
        private ArrayList<Pastel> listaProductosPastel = new ArrayList<>();
        private ArrayList<Carlota> listaProductosCarlota = new ArrayList<>();
        private ArrayList<Cupcake> listaProductosCupcake = new ArrayList<>();
        private ArrayList<Flan> listaProductosFlan = new ArrayList<>();
        private ArrayList<Gelatina> listaProductosGelatina = new ArrayList<>();
        private ArrayList<PostreFrutas> listaProductosPostreFrutas = new ArrayList<>();
        private ArrayList<Cliente> listaClientes = new ArrayList<>();
        private ArrayList<Insumo> listaInsumos = new ArrayList<>();

        public boolean addPedido(Pedido pedido) {
                return listaPedidos.add(pedido);
        }

        public boolean addPastel(Pastel pastel) {
                return listaProductosPastel.add(pastel);
        }

        public boolean addCarlota(Carlota carlota) {
                return listaProductosCarlota.add(carlota);
        }

        public boolean addCupcake(Cupcake cupcake) {
                return listaProductosCupcake.add(cupcake);
        }

        public boolean addFlan(Flan flan) {
                return listaProductosFlan.add(flan);
        }

        public boolean addGelatina(Gelatina gelatina) {
                return listaProductosGelatina.add(gelatina);
        }

        public boolean addPostreFrutas(PostreFrutas postreFrutas) {
                return listaProductosPostreFrutas.add(postreFrutas);
        }

        public boolean addCliente(Cliente cliente) {
                return listaClientes.add(cliente);
        }

        public boolean addInsumo(Insumo insumo) {
                return listaInsumos.add(insumo);
        }

        public ArrayList<Pedido> getListaPedidos() {
                return listaPedidos;
        }

        public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
                this.listaPedidos = listaPedidos;
        }

        public ArrayList<Pastel> getListaProductosPastel() {
                return listaProductosPastel;
        }

        public void setListaProductosPastel(ArrayList<Pastel> listaProductosPastel) {
                this.listaProductosPastel = listaProductosPastel;
        }

        public ArrayList<Carlota> getListaProductosCarlota() {
                return listaProductosCarlota;
        }

        public void setListaProductosCarlota(ArrayList<Carlota> listaProductosCarlota) {
                this.listaProductosCarlota = listaProductosCarlota;
        }

        public ArrayList<Cupcake> getListaProductosCupcake() {
                return listaProductosCupcake;
        }

        public void setListaProductosCupcake(ArrayList<Cupcake> listaProductosCupcake) {
                this.listaProductosCupcake = listaProductosCupcake;
        }

        public ArrayList<Flan> getListaProductosFlan() {
                return listaProductosFlan;
        }

        public void setListaProductosFlan(ArrayList<Flan> listaProductosFlan) {
                this.listaProductosFlan = listaProductosFlan;
        }

        public ArrayList<Gelatina> getListaProductosGelatina() {
                return listaProductosGelatina;
        }

        public void setListaProductosGelatina(ArrayList<Gelatina> listaProductosGelatina) {
                this.listaProductosGelatina = listaProductosGelatina;
        }

        public ArrayList<PostreFrutas> getListaProductosPostreFrutas() {
                return listaProductosPostreFrutas;
        }

        public void setListaProductosPostreFrutas(ArrayList<PostreFrutas> listaProductosPostreFrutas) {
                this.listaProductosPostreFrutas = listaProductosPostreFrutas;
        }

        public ArrayList<Cliente> getListaClientes() {
                return listaClientes;
        }

        public void setListaClientes(ArrayList<Cliente> listaClientes) {
                this.listaClientes = listaClientes;
        }

        public ArrayList<Insumo> getListaInsumos() {
                return listaInsumos;
        }

        public void setListaInsumos(ArrayList<Insumo> listaInsumos) {
                this.listaInsumos = listaInsumos;
        }
        public boolean eliminarProducto(String id){
                boolean encontrado=false;
                boolean status;
                boolean bandera = false;
                int index = 0;
                while (!bandera && index < listaProductosPostreFrutas.size()) {
                        if (listaProductosPostreFrutas.get(index).getId().indexOf(id) >= 0 && listaProductosPostreFrutas.get(index).isStatus()){
                                 bandera = true;
                                 status = false;
                                 encontrado=true;
                                 listaProductosPostreFrutas.get(index).setStatus(status);
                        }
                        index++;
                }
                index=0;
                while (!bandera && index < listaProductosCupcake.size()) {
                        if (listaProductosCupcake.get(index).getId().indexOf(id) >= 0 && listaProductosCupcake.get(index).isStatus()) {
                                bandera = true;
                                status = false;
                                encontrado=true;
                                listaProductosCupcake.get(index).setStatus(status);
                        }
                        index++;
                }
                index = 0;
                while (!bandera && index < listaProductosCarlota.size()) {
                        if (listaProductosCarlota.get(index).getId().indexOf(id) >= 0 && listaProductosCarlota.get(index).isStatus()) {
                                bandera = true;
                                status = false;
                                encontrado=true;
                                listaProductosCarlota.get(index).setStatus(status);
                        }
                        index++;
                }
                index=0;
                while (!bandera && index < listaProductosFlan.size()) {
                        if (listaProductosFlan.get(index).getId().indexOf(id) >= 0 && listaProductosFlan.get(index).isStatus()) {
                                bandera = true;
                                status = false;
                                encontrado=true;
                                listaProductosFlan.get(index).setStatus(status);
                        }
                        index++;
                }
                index =0;
                while (!bandera && index < listaProductosPastel.size()) {
                        if (listaProductosPastel.get(index).getId().indexOf(id) >= 0 && listaProductosPastel.get(index).isStatus()) {
                                bandera = true;
                                status = false;
                                encontrado=true;
                                listaProductosPastel.get(index).setStatus(status);
                        }
                        index++;
                }
                index=0;
                while (!bandera && index < listaProductosGelatina.size()) {
                        if (listaProductosGelatina.get(index).getId().indexOf(id) >= 0 && listaProductosGelatina.get(index).isStatus()) {
                                bandera = true;
                                status = false;
                                encontrado=true;
                                listaProductosGelatina.get(index).setStatus(status);
                        }
                        index++;
                }
                return encontrado;
        }
        public boolean eliminarInsumo(String id) {
                boolean encontrado = false;
                boolean status;
                int index = 0;
                boolean bandera = false;
                while (!bandera && index < listaInsumos.size()) {
                        if (listaInsumos.get(index).getId().indexOf(id) >= 0 && listaInsumos.get(index).isStatus()) {
                                bandera = true;
                                status = false;
                                encontrado = true;
                                listaInsumos.get(index).setStatus(status);
                        }
                        index++;
                }
                return encontrado;
        }
        public void ordenamiento() {
                Pedido pedidoTemporal;
                boolean cambios;
                do {
                 cambios=false;
                 for (int i = 0; i<listaPedidos.size()-1;i++){
                         if (listaPedidos.get(i).getFechaDeEntrega().isAfter(listaPedidos.get(i+1).getFechaDeEntrega()) ){
                                 pedidoTemporal=listaPedidos.get(i);
                                 listaPedidos.set(i,listaPedidos.get(i+1));
                                 listaPedidos.set(i+1,pedidoTemporal);
                                 cambios=true;
                         }
                 }
                }while (cambios);
        }

        public boolean cancelarPedido(String id){
                boolean encontrado = false;
                String status;
                int index = 0;
                boolean bandera = false;
                while (!bandera && index < listaPedidos.size()) {
                        if (listaPedidos.get(index).getId().indexOf(id) >= 0&& !listaPedidos.get(index).getStatus().equals("Cancelado") && !listaPedidos.get(index).getStatus().equals("Entregado")) {
                                bandera = true;
                                status = "Cancelado";
                                encontrado = true;
                                listaPedidos.get(index).setStatus(status);
                        }
                        index++;
                }
                return encontrado;
        }
}
