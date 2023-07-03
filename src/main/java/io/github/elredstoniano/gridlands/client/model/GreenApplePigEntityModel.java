package io.github.elredstoniano.gridlands.client.model;// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import io.github.elredstoniano.gridlands.GridLands;
import io.github.elredstoniano.gridlands.entity.GreenApplePigEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class GreenApplePigEntityModel<T extends GreenApplePigEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(GridLands.MODID, "green_apple_pig"), "main");
	private final ModelParts parts;

	public GreenApplePigEntityModel(ModelPart root) {
		//this.body = root.getChild("body");
		ModelPart body = root.getChild("body");
		ModelPart head = body.getChild("head");
		ModelPart legs = body.getChild("legs");
		ModelPart frontLeftLeg = legs.getChild("frontLeft");
		ModelPart frontRightLeg = legs.getChild("frontRight");
		ModelPart backLeftLeg = legs.getChild("backLeft");
		ModelPart backRightLeg = legs.getChild("backRight");

		this.parts = new ModelParts(body, head, legs, frontLeftLeg, frontRightLeg, backLeftLeg, backRightLeg);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -4.0F, -7.5F, 10.0F, 8.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 0.5F));

		PartDefinition legs = body.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, -0.5F));

		PartDefinition frontLeft = legs.addOrReplaceChild("frontLeft", CubeListBuilder.create().texOffs(34, 24).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, -6.0F));

		PartDefinition frontRight = legs.addOrReplaceChild("frontRight", CubeListBuilder.create().texOffs(25, 32).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 0.0F, -6.0F));

		PartDefinition backRight = legs.addOrReplaceChild("backRight", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 0.0F, 7.0F));

		PartDefinition backLeft = legs.addOrReplaceChild("backLeft", CubeListBuilder.create().texOffs(25, 24).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, 7.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 24).addBox(-3.0F, -6.0F, -4.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, -7.5F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		//if (entity.isInPowderSnow)// se puede cambiar la animacion respecto al estado de la entidad
		// En vez de usar Math.toRadians(var):
		// this.parts.head.yRot = netHeadYaw * ( (float) Math.PI / 100f); // convirtiendo a radianes // yaw
		this.parts.head().yRot = netHeadYaw * Mth.DEG_TO_RAD;
		this.parts.head().xRot = headPitch * Mth.DEG_TO_RAD;
		this.parts.frontLeftLeg().xRot = Mth.cos(limbSwing * 0.6662F) /*numero "mágico"*/
			* 1.4F * limbSwingAmount;
		this.parts.frontRightLeg().xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI)
				* 1.4F * limbSwingAmount; // + (float) Math.PI es para hacer que se mueva hacia la dirección contratia
		// Se repite lo mismo pero con las otras 2 piernas e invirtiendo la dirección del lado contrario al anterior
		this.parts.backLeftLeg().xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.parts.backRightLeg().xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.parts.body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	private record ModelParts(ModelPart body, ModelPart head, ModelPart legs, ModelPart frontLeftLeg, ModelPart frontRightLeg, ModelPart backLeftLeg, ModelPart backRightLeg){}
}