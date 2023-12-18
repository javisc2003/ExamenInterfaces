package com.example.examen2.models;

import java.sql.Date;

public class Coche {

        private String matricula;
        private String modelo;
        private String tarifa;
        private int coste;
        private Date fechaentrada;
        private Date fechasalida;
        private String cliente;

        public Coche() {
        }


        public String getMatricula() {
                return this.matricula;
        }

        public String getModelo() {
                return this.modelo;
        }

        public String getTarifa() {
                return this.tarifa;
        }

        public int getCoste() {
                return this.coste;
        }

        public Date getFechaentrada() {
                return this.fechaentrada;
        }

        public Date getFechasalida() {
                return this.fechasalida;
        }

        public String getCliente() {
                return this.cliente;
        }

        public void setMatricula(String matricula) {
                this.matricula = matricula;
        }

        public void setModelo(String modelo) {
                this.modelo = modelo;
        }

        public void setTarifa(String tarifa) {
                this.tarifa = tarifa;
        }

        public void setCoste(int coste) {
                this.coste = coste;
        }

        public void setFechaentrada(Date fechaentrada) {
                this.fechaentrada = fechaentrada;
        }

        public void setFechasalida(Date fechasalida) {
                this.fechasalida = fechasalida;
        }

        public void setCliente(String cliente) {
                this.cliente = cliente;
        }

        public boolean equals(final Object o) {
                if (o == this) return true;
                if (!(o instanceof Coche)) return false;
                final Coche other = (Coche) o;
                if (!other.canEqual((Object) this)) return false;
                final Object this$matricula = this.getMatricula();
                final Object other$matricula = other.getMatricula();
                if (this$matricula == null ? other$matricula != null : !this$matricula.equals(other$matricula))
                        return false;
                final Object this$modelo = this.getModelo();
                final Object other$modelo = other.getModelo();
                if (this$modelo == null ? other$modelo != null : !this$modelo.equals(other$modelo)) return false;
                final Object this$tarifa = this.getTarifa();
                final Object other$tarifa = other.getTarifa();
                if (this$tarifa == null ? other$tarifa != null : !this$tarifa.equals(other$tarifa)) return false;
                if (this.getCoste() != other.getCoste()) return false;
                final Object this$fechaentrada = this.getFechaentrada();
                final Object other$fechaentrada = other.getFechaentrada();
                if (this$fechaentrada == null ? other$fechaentrada != null : !this$fechaentrada.equals(other$fechaentrada))
                        return false;
                final Object this$fechasalida = this.getFechasalida();
                final Object other$fechasalida = other.getFechasalida();
                if (this$fechasalida == null ? other$fechasalida != null : !this$fechasalida.equals(other$fechasalida))
                        return false;
                final Object this$cliente = this.getCliente();
                final Object other$cliente = other.getCliente();
                if (this$cliente == null ? other$cliente != null : !this$cliente.equals(other$cliente)) return false;
                return true;
        }

        protected boolean canEqual(final Object other) {
                return other instanceof Coche;
        }

        public int hashCode() {
                final int PRIME = 59;
                int result = 1;
                final Object $matricula = this.getMatricula();
                result = result * PRIME + ($matricula == null ? 43 : $matricula.hashCode());
                final Object $modelo = this.getModelo();
                result = result * PRIME + ($modelo == null ? 43 : $modelo.hashCode());
                final Object $tarifa = this.getTarifa();
                result = result * PRIME + ($tarifa == null ? 43 : $tarifa.hashCode());
                result = result * PRIME + this.getCoste();
                final Object $fechaentrada = this.getFechaentrada();
                result = result * PRIME + ($fechaentrada == null ? 43 : $fechaentrada.hashCode());
                final Object $fechasalida = this.getFechasalida();
                result = result * PRIME + ($fechasalida == null ? 43 : $fechasalida.hashCode());
                final Object $cliente = this.getCliente();
                result = result * PRIME + ($cliente == null ? 43 : $cliente.hashCode());
                return result;
        }

        public String toString() {
                return "Coche(matricula=" + this.getMatricula() + ", modelo=" + this.getModelo() + ", tarifa=" + this.getTarifa() + ", coste=" + this.getCoste() + ", fechaentrada=" + this.getFechaentrada() + ", fechasalida=" + this.getFechasalida() + ", cliente=" + this.getCliente() + ")";
        }
}
