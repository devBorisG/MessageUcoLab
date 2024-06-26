package co.edu.uco.core.domain.entities;

public abstract class Entity<ID> {
        private ID id;

        protected final void setId(ID id) {
            this.id = id;
        }

        public final ID getId() {
            return id;
        }
}
